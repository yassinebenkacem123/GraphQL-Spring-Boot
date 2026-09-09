package com.tryit.graphQL.services;

import com.tryit.graphQL.entity.Book;
import com.tryit.graphQL.repositories.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bookRepo;

    @Override
    public List<Book> getBooks() {
        List<Book> books = bookRepo.findAll();
        if(books.isEmpty()){
            return null;
        }
        return books;
    }
}
