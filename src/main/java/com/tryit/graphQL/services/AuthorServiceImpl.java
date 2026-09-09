package com.tryit.graphQL.services;

import com.tryit.graphQL.DTO.AuthorDTO;
import com.tryit.graphQL.entity.Author;
import com.tryit.graphQL.repositories.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public List<Author> getAuthors() {
        List<Author> authors = authorRepo.findAll();
        if(authors.isEmpty()){
            return null;
        }
        return authors;
    }

    @Override
    public void createAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.getName());
        author.setEmail(authorDTO.getEmail());
        authorRepo.save(author);
    }
}
