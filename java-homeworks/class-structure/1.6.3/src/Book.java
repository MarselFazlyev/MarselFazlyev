public class Book {
    public int numberOfPages;
    public String genre;
    public String author;
    public int yearOfManufacture;
    public String title;

    public Book(int numberOfPages, String genre, String author, int yearOfManufacture, String title) {
        this.numberOfPages = numberOfPages;
        this.genre = genre;
        this.author = author;
        this.yearOfManufacture = yearOfManufacture;
        this.title = title;
    }

    public String toString() {
        return "Размер книги-[" + numberOfPages + "]страниц;\nЖанр-" + genre + "\nАвтор-" + author + "\nГод выпуска-" + yearOfManufacture + "\nНазвание книги-" + title;
    }

    public void isBookOld() {
        if (yearOfManufacture < 2000) {
            System.out.println("Книга древняя");
        } else {
            System.out.println("Книга cовременная");
        }
    }


}