package kodlamaio.hrms.entities.concretes;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="Positions")
public class Position
{
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="employer_id")
    private int employerId;

    @Column(name="name")
    private String name;
}
