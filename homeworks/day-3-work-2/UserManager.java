public class UserManager
{
    public void create(User user)
    {
        System.out.println(user.getId() + " created");
    }

    public void update(User user)
    {
        System.out.println(user.getId() + " updated");
    }

    public void delete(User user)
    {
        System.out.println(user.getId() + " deleted");
    }
}

