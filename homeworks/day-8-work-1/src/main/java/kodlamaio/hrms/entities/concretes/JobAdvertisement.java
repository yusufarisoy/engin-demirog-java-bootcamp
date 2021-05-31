package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @Column(name = "status")//Active or Passive
    private boolean status;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @ManyToOne()
    @Column(name = "position_id")
    private Position position;

    @Column(name = "description")
    private String description;

    @Column(name = "city")
    private String city;

    @Column(name = "minimum_salary")
    private double minSalary;

    @Column(name = "maximum_salary")
    private double maxSalary;

    @Column(name = "position_count")
    private int positionCount;

    @Column(name = "last_apply_date")
    private LocalDate lastApplyDate;
}
