import Interfaces.*;
import Book.*;
import Users.*;

public class Main {
    
    public static void main(String[] args) {
        Book book = new Book("Азбука", 2000);
        Reader chitatel = new Readerimpl("Милана", "Читатель");
        Librarian bibliotekar = new Librarianimpl("Татьяна", "Библиотекарь");
        chitatel.takeABook(book, bibliotekar);
        chitatel.returnABook(book, bibliotekar);
        System.out.println();

        Librarian librarian = new Librarianimpl(" Михаил", "Библиотекарь");
        Supplier supplier = new Supplierimpl("Ашот", "Поставщик");
        librarian.orderABook(book, supplier);
        System.out.println();

        Supplier supplier1 = new Supplierimpl("Евгений", "Поставщик");
        User user = new Supplierimpl(" Ольга", "Библиотекарь");
        supplier1.bringABook(book, user);
        System.out.println();

        Administrator admin = new Administratorimpl("Дарья", "Администратор");
        admin.giveAbook(book, user);
        Readerimpl dolzhnik = new Readerimpl("Дмитрий ", "Читатель-балбес");
        admin.overdueNotification(book,dolzhnik);
        admin.giveAbook(book,chitatel);



    }


}
