package Verification;

import java.time.LocalDate;

public class EdevletVerificationService implements UserVerificationService
{
    @Override
    public boolean verificateUserInformation(String nationalityId, String name, String surname, LocalDate birthdate)
    {
        //E-devlet verification simulation
        return nationalityId.length() == 11 && !name.matches("") && !surname.matches("");
    }
}
