package dev.startup.books.services;

import dev.startup.books.entity.Book;
import dev.startup.books.entity.BookEntity;
import dev.startup.books.mapper.BookMapper;
import dev.startup.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository repo;

    @Autowired
    public BookServiceImpl(BookRepository repo) {
        this.repo = repo;
    }

    @Override
    public Book creat(Book book) {
        BookEntity bookEntity = BookMapper.bookToBookEntity(book);
         return BookMapper.bookEntityToBook(repo.save(bookEntity));
    }

    @Override
    public Book updateById(Book book, String isbn) {

        return null;
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public String deleteBookById(String isbn) {
        return null;
    }

    @Override
    public Optional<Book> findById(String isbn) {
        return repo.findById(isbn).map(BookMapper::bookEntityToBook);
    }
}
