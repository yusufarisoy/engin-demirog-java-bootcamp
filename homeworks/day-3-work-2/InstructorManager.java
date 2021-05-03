public class InstructorManager extends UserManager
{
    @Override
    public void create(User user)
    {
        System.out.println("Instructor created: " + user.getId());
    }
}

