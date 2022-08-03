public class Author {
    public static int maxRating;
    public String surname;
    public int age;
    public int rating;
    public Book book;

    public Author(String surname, int age, int rating, Book book) {
        this.surname = surname;
        this.age = age;
        this.rating = rating;
        this.book = book;
        maxRating = Math.max(maxRating, rating);
    }

    public String toString() {
        return "Фамилия автора: " + surname + "\nВозраст автора: " + age + "\nРейтинг автора " + rating + "\nКнига автора:\n" + book;

    }


}

