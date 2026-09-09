package com.tryit.graphQL.controllers;

import com.tryit.graphQL.entity.Book;
import com.tryit.graphQL.services.BookService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    public final BookService bookService;
    public  BookController(BookService bookService){
        this.bookService = bookService;
    }

    @QueryMapping
    public List<Book> books(){
        return bookService.getBooks();
    }

}
