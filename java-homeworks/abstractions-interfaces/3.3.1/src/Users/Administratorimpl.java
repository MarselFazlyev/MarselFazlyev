package Users;

import Book.*;
import Interfaces.*;

public class Administratorimpl extends User {

    public Administratorimpl(String name, String type) {
        super(name, type);
    }

    @Override
    public void giveAbook(Book book, Reader reader) {
        System.out.println(this + " нашел и выдал книгу " + book + " " + reader);
    }

    @Override
    public void overdueNotification(Book book, Reader reader) {
        System.out.println(this + " предупредил о приближающейся просрочке " + reader);

    }

    @Override
    public void bringABook(Book book, Librarian librarianr) {
    }


    @Override
    public void takeABook(Book book, Librarian librarian) {
    }

    @Override
    public void returnABook(Book book, Librarian librarian) {
    }

    @Override
    public void orderABook(Book book, Supplier supplier) {
    }


}
