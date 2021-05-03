public class Instructor extends User
{
    private String name;
    private double salary;

    public Instructor(int id, String name, Logger[] loggers, String mail, double salary)
    {
        super(id, mail, loggers);
        setName(name);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

