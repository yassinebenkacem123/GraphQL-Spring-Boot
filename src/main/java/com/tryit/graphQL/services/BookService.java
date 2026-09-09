package com.tryit.graphQL.services;

import com.tryit.graphQL.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
}
