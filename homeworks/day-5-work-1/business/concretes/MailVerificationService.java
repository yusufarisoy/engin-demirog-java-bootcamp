package business.concretes;

import business.abstracts.VerificationService;
import entities.concretes.User;

public class MailVerificationService implements VerificationService
{
    @Override
    public void sendVerification(User user) {
        System.out.println("Verification mail for " + user.getId() + " send to : " + user.getMail());
    }
}
