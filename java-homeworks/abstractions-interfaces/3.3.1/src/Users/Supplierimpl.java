package Users;

import Book.*;
import Interfaces.*;

public class Supplierimpl extends User {
    public Supplierimpl(String name, String type) {
        super(name, type);
    }

    @Override
    public void bringABook(Book book, Librarian librarian) {
        System.out.println(this + " принес книгу " + book + " " + librarian);
    }


    @Override
    public void takeABook(Book book, Librarian librarian) {
        System.out.println(this + " взял почитать книгу у  " + librarian);
    }

    @Override
    public void returnABook(Book book, Librarian librarian) {
        System.out.println(this + " отдал обратно книгу " + librarian);
    }

    @Override
    public void orderABook(Book book, Supplier supplier) {
        System.out.println(this + " принял под заказ книгу " + book + " у " + supplier);

    }

    @Override
    public void giveAbook(Book book, Reader reader) {

    }

    @Override
    public void overdueNotification(Book book, Reader reader) {

    }


}
