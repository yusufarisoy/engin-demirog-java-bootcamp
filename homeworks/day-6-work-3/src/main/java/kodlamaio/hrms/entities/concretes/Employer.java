package kodlamaio.hrms.entities.concretes;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="Employers")
public class Employer implements User
{
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="firm_name")
    private String name;

    @Column(name="firm_mail")
    private String mail;

    @Column(name="phone_number")
    private String phone;

    @Column(name="password")
    private String password;
}
