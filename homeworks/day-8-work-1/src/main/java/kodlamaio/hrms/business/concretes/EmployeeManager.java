package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.Utils;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeManager implements EmployeeService
{
    private final EmployeeDao employeeDao;
    private final VerificationService[] verificationServices;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao, VerificationService[] verificationServices) {
        super();
        this.employeeDao = employeeDao;
        this.verificationServices = verificationServices;
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<>(this.employeeDao.findAll(), "Employee list returned successfully");
    }

    @Override
    public Result add(Employee employee, String passwordRepeat) {
        if(employee.getPassword().equals(passwordRepeat)) {
            List<Employee> list = this.employeeDao.findAll();
            for(Employee emp : list) {
                if(emp.getMail().equals(employee.getMail()) || emp.getNationalityId().equals(employee.getNationalityId())) {
                    return new ErrorResult("Account already exists!");
                }
            }

            if(!Utils.runVerificationServices(verificationServices, employee)) {
                return new ErrorResult("Please provide valid data!");
            }

            this.employeeDao.save(employee);
            return new SuccessResult("Employee added - mail verified!");
        }

        return new ErrorResult("Please provide valid data!");
    }
}
