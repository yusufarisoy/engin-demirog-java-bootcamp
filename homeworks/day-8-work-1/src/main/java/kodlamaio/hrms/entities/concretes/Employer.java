package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Employers")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdvertisements" })
public class Employer implements User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "employer")
    @JsonIgnore
    private List<Employee> employees;

    @OneToMany(mappedBy = "employer")
    @JsonIgnore
    private List<Position> positions;

    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;
}
