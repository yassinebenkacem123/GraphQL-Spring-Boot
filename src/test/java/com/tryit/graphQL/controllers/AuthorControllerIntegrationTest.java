package com.tryit.graphQL.controllers;

import com.tryit.graphQL.entity.Author;
import com.tryit.graphQL.services.AuthorService;
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
public class AuthorControllerIntegrationTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @MockBean
    private AuthorService authorService;

    @Test
    void authorsQuery_ShouldReturnAllAuthors() {
        Author author = new Author();
        author.setAuthorId(1L);
        author.setName("John Doe");
        author.setEmail("john@example.com");

        when(authorService.getAuthors()).thenReturn(Arrays.asList(author));

        String query = "{ authors { authorId name email } }";

        graphQlTester.document(query)
                .execute()
                .path("authors")
                .entityList(Author.class)
                .hasSize(1);
    }
}
