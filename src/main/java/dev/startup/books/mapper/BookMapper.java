package dev.startup.books.mapper;

import dev.startup.books.entity.Book;
import dev.startup.books.entity.BookEntity;

public class BookMapper {

    public static BookEntity bookToBookEntity(Book book){
     return  BookEntity.builder()
             .isbn(book.getIsbn())
             .author(book.getAuthor())
             .title(book.getTitle()).build();
    }

    public static Book bookEntityToBook(BookEntity bookEntity){
        return Book.builder()
                .isbn(bookEntity.getIsbn())
                .author(bookEntity.getAuthor())
                .title(bookEntity.getTitle())
                .build();
    }
}
