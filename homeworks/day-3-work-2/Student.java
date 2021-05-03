public class Student extends User
{
    private String name;
    private String password;

    public Student(int id, String mail, Logger[] loggers, String name, String password)
    {
        super(id, mail, loggers);
        setName(name);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

