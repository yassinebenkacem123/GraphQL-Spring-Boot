package com.tryit.graphQL.controllers;

import com.tryit.graphQL.DTO.AuthorDTO;
import com.tryit.graphQL.DTO.ResponseDTO;
import com.tryit.graphQL.entity.Author;
import com.tryit.graphQL.services.AuthorService;
import org.apache.coyote.Response;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {

    private final AuthorService authorService;


    public  AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @QueryMapping
    public List<Author> authors(){
        return authorService.getAuthors();
    }

    @MutationMapping
    public ResponseDTO createAuthor(
            @Argument AuthorDTO authorDTO
    ){
        authorService.createAuthor(authorDTO);

        return new ResponseDTO(
                "True", "Author created successuflly..."
        );
    }

}
