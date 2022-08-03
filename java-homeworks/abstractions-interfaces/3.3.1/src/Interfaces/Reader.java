package Interfaces;

import Book.*;

public interface Reader {
    void takeABook(Book book, Librarian librarian);

    void returnABook(Book book, Librarian librarian);
}
