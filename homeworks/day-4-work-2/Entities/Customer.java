package Entities;

public class Customer
{
    private int id;
    private String nationalityId;
    private int yearOfBirth;
    private String firstName;
    private String lasName;

    public Customer(int id, String nationalityId, int yearOfBirth, String firstName, String lasName)
    {
        this.id = id;
        this.nationalityId = nationalityId;
        this.yearOfBirth = yearOfBirth;
        this.firstName = firstName;
        this.lasName = lasName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(String nationalityId) {
        this.nationalityId = nationalityId;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasName() {
        return lasName;
    }

    public void setLasName(String lasName) {
        this.lasName = lasName;
    }
}
