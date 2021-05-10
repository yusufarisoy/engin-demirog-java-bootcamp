package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.Employer;
import java.util.List;

public interface EmployerService {
    List<Employer> getAll();
}
