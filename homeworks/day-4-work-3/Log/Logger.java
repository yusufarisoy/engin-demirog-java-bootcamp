package Log;

import User.User;
import java.time.LocalDate;

public interface Logger
{
    void log(User user, String message, LocalDate date);

    void logError(String description, LocalDate date);
}
