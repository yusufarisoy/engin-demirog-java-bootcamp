package Verification;

import java.time.LocalDate;

public interface UserVerificationService
{
    //Any verification service (SMS, Email) can be implemented easily. SOLID
    boolean verificateUserInformation(String nationalityId, String name, String surname, LocalDate birthdate);
}