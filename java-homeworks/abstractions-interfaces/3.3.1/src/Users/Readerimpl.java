package Users;

import Book.*;
import Interfaces.*;

public class Readerimpl extends User {

    public Readerimpl(String name, String type) {
        super(name, type);
    }

    @Override
    public void takeABook(Book book, Librarian librarian) {
        System.out.println(this + " взял книгу " + book + " у " + librarian);
    }

    @Override
    public void returnABook(Book book, Librarian librarian) {
        System.out.println(this + " вернул книгу " + book + " " + librarian);
    }

    @Override
    public void orderABook(Book book, Supplier supplier) {
    }

    @Override
    public void giveAbook(Book book, Reader reader) {

    }

    @Override
    public void overdueNotification(Book book, Reader reader) {
        System.out.println(this + " был предупрежден  " + reader + " о приближающейся просрочке книги " + book);

    }

    @Override
    public void bringABook(Book book, Librarian librarian) {

    }
}
