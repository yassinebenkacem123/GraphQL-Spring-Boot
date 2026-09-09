package com.tryit.graphQL.services;

import com.tryit.graphQL.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthors();
}
