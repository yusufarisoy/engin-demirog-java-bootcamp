public class Main
{
    public static void main(String[] args)
    {
        Logger[] loggers = {new DatabaseLogger(), new SmsLogger()};

        Student user1 = new Student(1, "mail@mail.com", loggers, "Yusuf Gokmen Arisoy", "1234");
        Student user2 = new Student(2, "ali@mail.com", loggers, "Ali Uzun", "4321");
        User[] users = {user1, user2};

        StudentManager studentManager = new StudentManager();
        studentManager.create(user1);
    }
}

