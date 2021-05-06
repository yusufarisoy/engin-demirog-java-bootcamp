package dataAccess.concretes;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;
import java.util.List;

public class HibernateUserDao implements UserDao
{
    @Override
    public void add(User user) {
        System.out.println("Registered successfully with mail : " + user.getMail());
    }

    @Override
    public void update(User user) { }

    @Override
    public void delete(User user) { }

    @Override
    public User get(int id) { return null; }

    @Override
    public List<User> getAll() { return null; }

    @Override
    public List<String> getAllMails() { return null; }
    //All mails stored in the DB: can be replaced with a simple query which returns if user with mail already exists (SELECT 1 FROM users WHERE mail = :mail)
}
