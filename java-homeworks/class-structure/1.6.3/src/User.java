public class User {
    public static int totalOnline;
    public String name;
    public String surname;
    public String email;

    public User(String name, String surname, String email) {
        totalOnline++;
    }
}
