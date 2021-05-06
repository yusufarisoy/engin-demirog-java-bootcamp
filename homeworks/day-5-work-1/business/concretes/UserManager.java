package business.concretes;

import business.abstracts.UserService;
import core.abstracts.AuthenticationService;
import business.abstracts.VerificationService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager implements UserService
{
    public static final Pattern VALID_MAIL_ADDRESS = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private final UserDao userDao;
    private final AuthenticationService externalAuthenticationService;
    private final VerificationService verificationService;

    public UserManager(UserDao userDao, AuthenticationService authenticationService, VerificationService verificationService) {
        this.userDao = userDao;
        this.externalAuthenticationService = authenticationService;
        this.verificationService = verificationService;
    }

    @Override
    public void register(String mail, String password, String name, String surname)
    {
        if(isUserValid(mail, password, name, surname))
        {
            User user = new User(123, mail, password, name, surname, false);
            userDao.add(user);

            verificationService.sendVerification(user);//Mail Verification Service or else
            System.out.println("Registered Successfully! Please verify your e-mail address.");
        }
        else {
            System.out.println("Register Failed! Please fill the fields with valid information.");
        }
    }

    @Override
    public void registerWithExternalAccount()
    {
        externalAuthenticationService.register();
        System.out.println("Registered With External Account Successfully!");
        //Don't need to send verification mail cause user already using a verified account
    }

    @Override
    public void verifyMailAddress(int id)
    {
        User user = userDao.get(id);
        user.setEmailVerified(true);

        userDao.update(user);
        System.out.println("User with id " + user.getId() + " verified mail : " + user.getMail());
    }

    @Override
    public User signIn(String mail, String password)
    {
        if(isSignInInfoValid(mail, password))
        {
            for(User user : userDao.getAll())
            {
                if(user.getMail().equals(mail) && user.isPasswordCorrect(password))
                {
                    if(user.isEmailVerified()) {
                        System.out.println("Signed in successfully");
                        return user;
                    }

                    System.out.println("Please verify your e-mail address first.");
                    return null;
                }
            }
        }

        System.out.println("E-mail or password is incorrect!");
        return null;
    }

    private static boolean isMailValid(String mail) {
        Matcher matcher = VALID_MAIL_ADDRESS.matcher(mail);
        return matcher.find();
    }

    private boolean isUserValid(String mail, String password, String name, String surname)
    {
        if(password.length() > 5 && isMailValid(mail) && name.length() > 1 && surname.length() > 1)
        {
            for(String userMail : userDao.getAllMails())
            {
                if(mail.equals(userMail)) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    private boolean isSignInInfoValid(String mail, String password) {
        return password.length() > 5 && isMailValid(mail);
    }
}
