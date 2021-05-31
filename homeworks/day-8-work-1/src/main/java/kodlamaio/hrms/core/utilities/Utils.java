package kodlamaio.hrms.core.utilities;

import kodlamaio.hrms.core.abstracts.VerificationService;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;

public class Utils {

    public static boolean runVerificationServices(VerificationService[] verificationServices, Employee employee) {
        for(VerificationService service : verificationServices) {
            if(!service.verifyUser(employee)) {
                return false;
            }
        }

        return true;
    }

    public static boolean runVerificationServices(VerificationService[] verificationServices, Employer employer) {
        for(VerificationService service : verificationServices) {
            if(!service.verifyUser(employer)) {
                return false;
            }
        }

        return true;
    }
}
