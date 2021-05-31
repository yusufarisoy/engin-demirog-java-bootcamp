package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.Utils;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployerManager implements EmployerService
{
    private final EmployerDao employerDao;
    private final VerificationService[] verificationServices;

    @Autowired
    public EmployerManager(EmployerDao employerDao, VerificationService[] verificationServices) {
        super();
        this.employerDao = employerDao;
        this.verificationServices = verificationServices;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(this.employerDao.findAll(), "Employer list returned successfully");
    }

    @Override
    public Result add(Employer employer, String passwordRepeat) {
        if(employer.getPassword().equals(passwordRepeat)) {
            List<Employer> employers = this.employerDao.findAll();
            for(Employer emp : employers) {
                if(emp.getMail().equals(employer.getMail())) {
                    return new ErrorResult("Account already exists!");
                }
            }

            if(!Utils.runVerificationServices(verificationServices, employer)) {
                return new ErrorResult("Please provide valid data!");
            }

            this.employerDao.save(employer);
            return new SuccessResult("Employer added - mail verified");
        }

        return new ErrorResult("Please provide valid data!");
    }
}
