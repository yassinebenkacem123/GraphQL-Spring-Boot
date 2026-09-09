package com.tryit.graphQL.controllers;

import com.tryit.graphQL.entity.Author;
import com.tryit.graphQL.services.AuthorService;
import com.tryit.graphQL.services.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
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

}
