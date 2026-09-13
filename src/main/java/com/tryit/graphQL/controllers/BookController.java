package com.tryit.graphQL.controllers;

import com.tryit.graphQL.DTO.BookDTO;
import com.tryit.graphQL.DTO.ResponseDTO;
import com.tryit.graphQL.entity.Book;
import com.tryit.graphQL.services.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
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

    @MutationMapping
    public ResponseDTO createBook(@Argument BookDTO bookDTO){

        bookService.createBookService(bookDTO);
        return new ResponseDTO("true","Book created Successfully...");
    }

}
