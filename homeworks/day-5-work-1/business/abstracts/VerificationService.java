package business.abstracts;

import entities.concretes.User;

public interface VerificationService
{
    void sendVerification(User user);//On register, can be phone number or anything else in the future
}
