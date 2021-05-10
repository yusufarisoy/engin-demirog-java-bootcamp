package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
}
