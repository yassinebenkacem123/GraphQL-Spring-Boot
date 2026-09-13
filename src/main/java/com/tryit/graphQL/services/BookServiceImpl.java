package com.tryit.graphQL.services;

import com.tryit.graphQL.DTO.BookDTO;
import com.tryit.graphQL.entity.Author;
import com.tryit.graphQL.entity.Book;
import com.tryit.graphQL.repositories.AuthorRepo;
import com.tryit.graphQL.repositories.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public List<Book> getBooks() {
        List<Book> books = bookRepo.findAll();
        if(books.isEmpty()){
            return null;
        }
        return books;
    }

    @Override
    public void createBookService(@Argument BookDTO bookDTO) {
        Book bookToSave = new Book();

        Author author = authorRepo.findById(bookDTO.getAuthorId()).orElseThrow(
                ()-> new RuntimeException("Author not found")
        );

        bookToSave.setAuthor(author);
        bookToSave.setDescription(bookDTO.getDescription());
        bookToSave.setTitle(bookDTO.getTitle());

        bookRepo.save(bookToSave);

    }

}
