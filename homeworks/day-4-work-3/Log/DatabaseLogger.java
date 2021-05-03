package Log;

import User.User;
import java.time.LocalDate;

public class DatabaseLogger implements Logger
{
    @Override
    public void log(User user, String message, LocalDate date)
    {
        System.out.println("Database.Database Log -> ID: " + user.getId() + " | Username: " + user.getUsername() + " did : " + message + " at " + date);
    }

    @Override
    public void logError(String description, LocalDate date)
    {
        System.out.println("ERROR Log to Database.Database -> " + description + " at " + date);
    }
}
