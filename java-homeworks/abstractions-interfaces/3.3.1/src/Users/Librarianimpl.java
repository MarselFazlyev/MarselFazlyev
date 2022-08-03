package Users;

import Interfaces.*;
import Book.*;

public class Librarianimpl extends User {

    public Librarianimpl(String name, String type) {
        super(name, type);
    }


    @Override
    public void takeABook(Book book, Librarian librarian) {
        System.out.println(this + " отдал книгу " + book + " " + librarian);
    }

    @Override
    public void returnABook(Book book, Librarian librarian) {
        System.out.println(this + " принял обратно книгу " + book + " от " + librarian);
    }

    @Override
    public void orderABook(Book book, Supplier supplier) {
        System.out.println(this + " заказал книгу " + book + " " + supplier);

    }

    @Override
    public void giveAbook(Book book, Reader reader) {

    }

    @Override
    public void overdueNotification(Book book, Reader reader) {

    }

    @Override
    public void bringABook(Book book, Librarian librarian) {
    }
}
