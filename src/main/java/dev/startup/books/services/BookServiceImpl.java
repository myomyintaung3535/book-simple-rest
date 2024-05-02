package dev.startup.books.services;

import dev.startup.books.entity.Book;
import dev.startup.books.entity.BookEntity;
import dev.startup.books.mapper.BookMapper;
import dev.startup.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository repo;

    @Autowired
    public BookServiceImpl(BookRepository repo) {
        this.repo = repo;
    }

    @Override
    public Book create(Book book) {
        BookEntity bookEntity = BookMapper.bookToBookEntity(book);
         return BookMapper.bookEntityToBook(repo.save(bookEntity));
    }

    @Override
    public Book updateById(Book book, String isbn) {
        Optional<Book> optBook = findById(isbn);
        if (optBook.isPresent()){
            book.setIsbn(optBook.get().getIsbn());
          return create(book);
        }else {
            throw new RuntimeException("Can't Update Book");
        }
    }

    @Override
    public List<Book> findAll() {
        return  repo.findAll().stream().map(BookMapper::bookEntityToBook).collect(Collectors.toList());
    }

    @Override
    public void deleteBookById(String isbn) {
        repo.deleteById(isbn);
    }

    @Override
    public Optional<Book> findById(String isbn) {
        return repo.findById(isbn).map(BookMapper::bookEntityToBook);
    }
}
