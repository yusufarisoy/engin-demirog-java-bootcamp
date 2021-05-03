package User;

import Database.Database;
import Log.Logger;
import Verification.UserVerificationService;
import java.time.LocalDate;
import Utils.Utils;

public class UserManager
{
    private final Database db;
    private final Logger[] loggers;
    private final UserVerificationService userVerificationService;

    public UserManager(Database database, Logger[] loggers, UserVerificationService userVerificationService)
    {
        this.db = database;
        this.loggers = loggers;
        this.userVerificationService = userVerificationService;
    }

    public User create(Long id, String username, String password, String nationalityId, String name, String surname, LocalDate birthDate)
    {
        try
        {
            if(userVerificationService.verificateUserInformation(nationalityId, name, surname, birthDate))
            {
                User user = new User(id, username, password, nationalityId, name, surname, birthDate);
                db.insertToUsers(user);

                Utils.runLoggers(loggers, user, "register", LocalDate.now());
                return user;
            }
            else
                return null;
        }
        catch(Exception ex)
        {
            Utils.logErrors(loggers, "Exception on CREATE : " + ex.getMessage(), LocalDate.now());
            return null;
        }
    }

    public void update(User user, String username, String password, String nationalityId, String name, String surName, LocalDate birthDate)
    {
        try
        {
            user.setUsername(username);
            user.setPassword(password);
            user.setNationalityId(nationalityId);
            user.setName(name);
            user.setSurName(surName);
            user.setBirthDate(birthDate);
            db.updateUser(user);

            Utils.runLoggers(loggers, user, "update information", LocalDate.now());
        }
        catch (Exception ex) {
            Utils.logErrors(loggers, "Exception on UPDATE : " + ex.getMessage(), LocalDate.now());
        }
    }

    public void delete(User user)
    {
        try
        {
            db.deleteFromUsers(user.getId());

            Utils.runLoggers(loggers, user, "delete account", LocalDate.now());
        }
        catch(Exception ex) {
            Utils.logErrors(loggers, "Exception on DELETE : " + ex.getMessage(), LocalDate.now());
        }
    }
}
