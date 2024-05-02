package dev.startup.books.controller;

import dev.startup.books.entity.Book;
import dev.startup.books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> findById(@PathVariable String isbn){
        Optional<Book> optionalBook = bookService.findById(isbn);
        return optionalBook.map(book -> new ResponseEntity<>(book, HttpStatus.FOUND))
                           .orElseGet(() -> new ResponseEntity<>(bookService.findById(isbn).get(), HttpStatus.FOUND));
    }
    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        return ResponseEntity.ok(bookService.findAll());
    }
    @PostMapping
    public ResponseEntity<Book> creatBook(@RequestBody Book book){
       Book savedBook = bookService.create(book);
       return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<Book> updateBook(@PathVariable String isbn, @RequestBody Book book){
       return ResponseEntity.ok(bookService.updateById(book,isbn));
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<String> deleteById(@PathVariable String isbn){
        bookService.deleteBookById(isbn);
        return ResponseEntity.ok("Book Deleted");
    }


}
