package Utils;

import Log.Logger;
import User.User;

import java.time.LocalDate;

public class Utils
{
    public static void runLoggers(Logger[] loggers, User user, String message, LocalDate date)
    {
        for(Logger logger : loggers)
            logger.log(user, message, date);
        System.out.println();
    }

    public static void logErrors(Logger[] loggers, String description, LocalDate date)
    {
        for(Logger logger : loggers)
            logger.logError(description, date);
        System.out.println();
    }
}
