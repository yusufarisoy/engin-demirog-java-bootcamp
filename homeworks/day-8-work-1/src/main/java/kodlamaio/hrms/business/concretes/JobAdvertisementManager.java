package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private final JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        super();
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("Job advertisement added successfully");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatus(boolean status) {
        return new SuccessDataResult<>(this.jobAdvertisementDao.getByStatus(status), "All active||passive ads have been listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusAndReleaseDate(boolean status, LocalDate releaseDate) {
        return new SuccessDataResult<>(this.jobAdvertisementDao.getByStatusAndReleaseDate(status, releaseDate), "All active||passive ads have been listed according to their release date");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusAndEmployer(boolean status, int employerId) {
        return new SuccessDataResult<>(this.jobAdvertisementDao.getByStatusAndEmployer_Id(status, employerId), "All active||passive ads of an employer have been listed");
    }

    @Override
    public Result closeJobAdvertisement(int jobAdvertisementId) {
        if(this.jobAdvertisementDao.findById(jobAdvertisementId).isPresent()) {
            JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(jobAdvertisementId).get();
            jobAdvertisement.setStatus(false);
            this.jobAdvertisementDao.save(jobAdvertisement);

            return new SuccessResult("Job advertisement has closed");
        }

        return new ErrorResult("Job advertisement couldn't found");
    }
}
