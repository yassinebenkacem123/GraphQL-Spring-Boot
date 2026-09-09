package com.tryit.graphQL;

import java.util.*;
import java.util.stream.Collectors;

public record Book(
        Integer id,
        String name,
        Integer pageCount,
        String description,
        Integer authorId
) {
    public static List<Book> books = Arrays.asList(
            new Book(1, "be yourself", 320, "best book to read for today", 1),
            new Book(2, "From poverty to power", 320, "If you want to make your life better read it", 2),
            new Book(3, "Grow rich with peace of mind", 20, "This book will help u to be rich but with peace of mind",3)
    );


    public static Optional<Book> getBookById(Integer id) {
        Optional<Book> returnedBook = books.stream().filter(book -> book.id.equals(id)).toList().stream().findAny();
        if(returnedBook.isEmpty()){
            return null;
        }
        return  returnedBook;
    }
}
