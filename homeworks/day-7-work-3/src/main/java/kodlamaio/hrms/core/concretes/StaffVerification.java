package kodlamaio.hrms.core.concretes;

import kodlamaio.hrms.core.abstracts.VerificationService;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;

public class StaffVerification implements VerificationService {

    @Override
    public boolean verifyUser(Employer employer) {
        return true;
        //User reviewed by HRMS staff and verified
    }

    @Override
    public boolean verifyUser(Employee employee) {
        return false;
    }
}
