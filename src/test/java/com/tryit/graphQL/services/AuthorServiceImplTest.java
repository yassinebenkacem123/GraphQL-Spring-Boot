package com.tryit.graphQL.services;

import com.tryit.graphQL.DTO.AuthorDTO;
import com.tryit.graphQL.entity.Author;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceImplTest {

    @Mock
    private AuthorRepo authorRepo;

    @Mock
    private BookRepo bookRepo;

    @InjectMocks
    private AuthorServiceImpl authorService;

    private Author author;

    @BeforeEach
    void setUp() {
        author = new Author();
        author.setAuthorId(1L);
        author.setName("John Doe");
        author.setEmail("john@example.com");
    }

    @Test
    void getAuthors_ShouldReturnList_WhenAuthorsExist() {
        when(authorRepo.findAll()).thenReturn(Arrays.asList(author));

        List<Author> result = authorService.getAuthors();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
        verify(authorRepo, times(1)).findAll();
    }

    @Test
    void getAuthors_ShouldReturnNull_WhenNoAuthorsExist() {
        when(authorRepo.findAll()).thenReturn(Collections.emptyList());

        List<Author> result = authorService.getAuthors();

        assertNull(result);
        verify(authorRepo, times(1)).findAll();
    }

    @Test
    void createAuthor_ShouldSaveAuthor() {
        AuthorDTO authorDTO = new AuthorDTO("Jane Doe", "jane@example.com");

        authorService.createAuthor(authorDTO);

        verify(authorRepo, times(1)).save(any(Author.class));
    }

    @Test
    void deleteAuthor_ShouldDeleteBooksAndAuthor() {
        Long authorId = 1L;

        authorService.deleteAuthor(authorId);

        verify(bookRepo, times(1)).deleteAll();
        verify(authorRepo, times(1)).deleteById(authorId);
    }
}
