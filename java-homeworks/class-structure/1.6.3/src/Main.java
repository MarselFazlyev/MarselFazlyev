
class Main {
    public static void main(String[] args) {

        Book book1 = new Book(400, "Комедия", "Гоголь", 1829, "Вечера на хуторе близ Диканьки");
        System.out.println();
        System.out.println(book1);
        book1.isBookOld();
        System.out.println();
        Book book2 = new Book(350, "Роман", "Кинг", 2004, "Темная башня");
        System.out.println(book2);
        book2.isBookOld();
        System.out.println();
        Book book3 = new Book(200, "Стихи", "Лермонтов", 1839, "Мцыри");
        System.out.println(book3);
        book3.isBookOld();
        System.out.println();
        Book book4 = new Book(600, "Роман", "Купер", 1950, "Прерия");
        System.out.println(book4);
        book4.isBookOld();
        System.out.println();

        Author author1 = new Author("Лермонтов", 34, 4, book3);
        System.out.println(author1);
        System.out.println();
        Author author2 = new Author("Купер", 45, 6, book4);
        System.out.println(author2);
        System.out.println();
        System.out.println("Максимальный рейтинг среди авторов: " + Author.maxRating + " баллов.");

        User cristianoRonaldo = new User("Cristiano", "Ronaldo", "cr7@gmal.com");
        User chackNorris = new User("Chack", "Norris", "chack@gmail.com");
        User donaldTrump = new User("Donald", "Trump", "donaldduck@gmail.com");
        System.out.println("Общее количество онлайн пользователей: " + User.totalOnline + " человек.");


    }
}
