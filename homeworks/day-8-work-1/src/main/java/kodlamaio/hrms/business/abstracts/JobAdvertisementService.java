package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import java.time.LocalDate;
import java.util.List;

public interface JobAdvertisementService {
    Result add(JobAdvertisement jobAdvertisement);

    DataResult<List<JobAdvertisement>> getByStatus(boolean status);

    DataResult<List<JobAdvertisement>> getByStatusAndReleaseDate(boolean status, LocalDate releaseDate);

    DataResult<List<JobAdvertisement>> getByStatusAndEmployer(boolean status, int employerId);

    Result closeJobAdvertisement(int jobAdvertisementId);
}
