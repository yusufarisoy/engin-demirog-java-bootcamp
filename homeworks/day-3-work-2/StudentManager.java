public class StudentManager extends UserManager
{
    @Override
    public void create(User user)
    {
        System.out.println("User created: " + user.getId());

        Utils.runLoggers(user.loggers, user.getMail());
    }

    public void abc()
    {
        System.out.println("ABC");
    }
}

