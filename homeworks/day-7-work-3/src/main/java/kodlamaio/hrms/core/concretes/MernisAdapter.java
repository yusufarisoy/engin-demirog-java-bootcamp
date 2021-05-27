package kodlamaio.hrms.core.concretes;

import kodlamaio.hrms.Mernis.MernisManager;
import kodlamaio.hrms.core.abstracts.VerificationService;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;

public class MernisAdapter implements VerificationService {

    @Override
    public boolean verifyUser(Employee employee) {
        MernisManager mernisManager = new MernisManager();
        return mernisManager.verifyUser(employee.getNationalityId(), employee.getName(), employee.getSurname(), employee.getDateOfBirth());
    }

    @Override
    public boolean verifyUser(Employer employer) {
        return false;
    }
}
