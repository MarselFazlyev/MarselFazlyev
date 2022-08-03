package Interfaces;

import Book.*;

public interface Administrator {
    void giveAbook(Book book, Reader reader);

    void overdueNotification(Book book, Reader reader);
}
