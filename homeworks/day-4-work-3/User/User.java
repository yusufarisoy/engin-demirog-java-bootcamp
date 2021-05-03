package User;

import java.time.LocalDate;

public class User
{
    private final Long id;
    private String username;
    private String password;
    private String nationalityId;
    private String name;
    private String surname;
    private LocalDate birthdate;

    public User(Long id, String username, String password, String nationalityId, String name, String surName, LocalDate birthdate)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nationalityId = nationalityId;
        this.name = name;
        this.surname = surName;
        this.birthdate = birthdate;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(String nationalityId) {
        this.nationalityId = nationalityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surname;
    }

    public void setSurName(String surName) {
        this.surname = surName;
    }

    public LocalDate getBirthDate() {
        return birthdate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthdate = birthDate;
    }
}
