package dev.startup.books.services;

import dev.startup.books.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book creat(Book book);

    Book updateById(Book book, String isbn);

    List<Book> findAll();

    String deleteBookById(String isbn);

    Optional<Book> findById(String isbn);

}
