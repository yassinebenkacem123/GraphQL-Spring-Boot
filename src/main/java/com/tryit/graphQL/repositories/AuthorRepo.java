package com.tryit.graphQL.repositories;

import com.tryit.graphQL.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Double> {
}
