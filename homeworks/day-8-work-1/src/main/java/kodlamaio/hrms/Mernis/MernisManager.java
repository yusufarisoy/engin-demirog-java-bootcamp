package kodlamaio.hrms.Mernis;

import java.time.LocalDate;

public class MernisManager {
    public boolean verifyUser(String nationalityId, String name, String surname, LocalDate dateOfBirth) {
        return nationalityId.length() == 11 && name.length() > 3 && surname.length() > 3;
    }
}
