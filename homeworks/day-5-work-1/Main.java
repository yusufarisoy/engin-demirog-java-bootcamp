import business.abstracts.UserService;
import business.concretes.UserManager;
import core.concretes.GoogleAuthenticationManagerAdapter;
import business.concretes.MailVerificationService;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main
{
    public static void main(String[] args)
    {
        UserService userManager = new UserManager(new HibernateUserDao(), new GoogleAuthenticationManagerAdapter(), new MailVerificationService());

        //REGISTER
        userManager.register("yusufgokmenarisoy@gmail.com", "123456", "Yusuf Gökmen", "Arısoy");
        //OR
        userManager.registerWithExternalAccount();

        userManager.verifyMailAddress(1);//Id coming from Mail Service

        //SIGN IN
        User user = userManager.signIn("yusufgokmenarisoy@gmail.com", "123456");
    }
}
