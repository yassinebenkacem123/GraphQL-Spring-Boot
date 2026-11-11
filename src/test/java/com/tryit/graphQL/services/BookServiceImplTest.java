package com.tryit.graphQL.services;

import com.tryit.graphQL.DTO.BookDTO;
import com.tryit.graphQL.entity.Author;
import com.tryit.graphQL.entity.Book;
import com.tryit.graphQL.repositories.AuthorRepo;
import com.tryit.graphQL.repositories.BookRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

    @Mock
    private BookRepo bookRepo;

    @Mock
    private AuthorRepo authorRepo;

    @InjectMocks
    private BookServiceImpl bookService;

    private Book book;
    private Author author;

    @BeforeEach
    void setUp() {
        author = new Author();
        author.setAuthorId(1L);
        author.setName("Author Name");

        book = new Book();
        book.setBookId(1L);
        book.setTitle("Book Title");
        book.setDescription("Book Description");
        book.setAuthor(author);
    }

    @Test
    void getBooks_ShouldReturnList_WhenBooksExist() {
        when(bookRepo.findAll()).thenReturn(Arrays.asList(book));

        List<Book> result = bookService.getBooks();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Book Title", result.get(0).getTitle());
        verify(bookRepo, times(1)).findAll();
    }

    @Test
    void getBooks_ShouldReturnNull_WhenNoBooksExist() {
        when(bookRepo.findAll()).thenReturn(Collections.emptyList());

        List<Book> result = bookService.getBooks();

        assertNull(result);
        verify(bookRepo, times(1)).findAll();
    }

    @Test
    void createBookService_ShouldSaveBook_WhenAuthorExists() {
        BookDTO bookDTO = new BookDTO(1L, "New Book", "Description");
        when(authorRepo.findById(1L)).thenReturn(Optional.of(author));

        bookService.createBookService(bookDTO);

        verify(authorRepo, times(1)).findById(1L);
        verify(bookRepo, times(1)).save(any(Book.class));
    }

    @Test
    void createBookService_ShouldThrowException_WhenAuthorNotFound() {
        BookDTO bookDTO = new BookDTO(1L, "New Book", "Description");
        when(authorRepo.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> bookService.createBookService(bookDTO));
        verify(bookRepo, never()).save(any(Book.class));
    }

    @Test
    void deleteAuthorBook_ShouldDeleteBook() {
        Long bookId = 1L;

        bookService.deleteAuthorBook(bookId);

        verify(bookRepo, times(1)).deleteById(bookId);
    }
}
