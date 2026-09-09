package com.tryit.graphQL;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {

    @QueryMapping
    public List<Author> authors(){
        return Author.authors;
    }
}
