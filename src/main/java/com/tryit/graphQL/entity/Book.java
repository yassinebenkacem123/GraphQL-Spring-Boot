package com.tryit.graphQL.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double bookId;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}