package dev.startup.books.service;

import dev.startup.books.entity.Book;
import dev.startup.books.entity.BookEntity;
import dev.startup.books.repository.BookRepository;
import dev.startup.books.services.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

    @Mock
    private BookRepository repo;
    @InjectMocks
    private BookServiceImpl bookServiceImpl;

    @Test
    public void testThatBookIsSaved(){
        Book book = Book.builder()
                        .isbn("012345")
                        .author("James")
                        .title("The Waves")
                        .build();

        BookEntity bookEntity = BookEntity.builder()
                                          .isbn("012345")
                                          .author("James")
                                          .title("The Waves")
                                          .build();
        when(repo.save(eq(bookEntity))).thenReturn(bookEntity);

       Book savedBook =bookServiceImpl.creat(book);
       assertEquals(book,savedBook);
    }
}
