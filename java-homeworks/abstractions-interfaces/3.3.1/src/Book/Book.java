package Book;

public class Book {
    String title;
    int yearOfRelease;

    public Book(String title, int yearOfRelease) {
        this.title = title;
        this.yearOfRelease = yearOfRelease;
    }

    public String toString() {
        return (("\"" + title + "\" " + yearOfRelease + " года издания"));
    }
}

