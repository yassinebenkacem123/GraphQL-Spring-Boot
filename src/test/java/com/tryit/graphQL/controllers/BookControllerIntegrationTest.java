package com.tryit.graphQL.controllers;

import com.tryit.graphQL.entity.Book;
import com.tryit.graphQL.services.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureGraphQlTester
@ActiveProfiles("test")
public class BookControllerIntegrationTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @MockBean
    private BookService bookService;

    @Test
    void booksQuery_ShouldReturnAllBooks() {
        Book book = new Book();
        book.setBookId(1L);
        book.setTitle("Book Title");
        book.setDescription("Book Description");

        when(bookService.getBooks()).thenReturn(Arrays.asList(book));

        String query = "{ books { bookId title description } }";

        graphQlTester.document(query)
                .execute()
                .path("books")
                .entityList(Book.class)
                .hasSize(1);
    }
}
