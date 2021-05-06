package business.abstracts;

import entities.concretes.User;

public interface UserService
{
    void register(String mail, String password, String name, String surname);
    User signIn(String mail, String password);
    void registerWithExternalAccount();
    void verifyMailAddress(int id);//On verify link clicked
}
