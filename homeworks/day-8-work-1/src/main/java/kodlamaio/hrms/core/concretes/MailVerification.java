package kodlamaio.hrms.core.concretes;

import kodlamaio.hrms.core.abstracts.VerificationService;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;

public class MailVerification implements VerificationService {

    @Override
    public boolean verifyUser(Employee employee) {
        //Verification send to employee.getMail() and verified by user
        return true;
    }

    @Override
    public boolean verifyUser(Employer employer) {
        //Verification send to employer.getMail() and verified by user
        return true;
    }
}
