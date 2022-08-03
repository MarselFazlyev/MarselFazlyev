package marsel;

public class User {
    private String login;
    private int password;
    private int age;
    private String email;

    public User(String login, int password, int age, String email) {
        this.login = login;
        this.password = password;
        this.age = age;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public int getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}

