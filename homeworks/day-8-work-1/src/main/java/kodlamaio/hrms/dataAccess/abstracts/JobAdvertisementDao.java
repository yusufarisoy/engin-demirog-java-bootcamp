package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> getByStatus(boolean status);

    List<JobAdvertisement> getByStatusAndReleaseDate(boolean status, LocalDate releaseDate);

    List<JobAdvertisement> getByStatusAndEmployer_Id(boolean status, int employerId);
}
