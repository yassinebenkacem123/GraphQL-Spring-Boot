package com.tryit.graphQL.repositories;

import com.tryit.graphQL.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Double> {
}
