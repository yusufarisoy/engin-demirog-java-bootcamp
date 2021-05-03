public abstract class User
{
    private int id;
    private String mail;
    Logger[] loggers;

    public User(int id, String mail, Logger[] loggers)
    {
        setId(id);
        setMail(mail);
        this.loggers = loggers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}

