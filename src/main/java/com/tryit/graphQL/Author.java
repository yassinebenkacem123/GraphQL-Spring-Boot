package com.tryit.graphQL;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Author(
        Integer id,
        String name,
        String dateOfBirth

) {
    public static List<Author> authors = Arrays.asList(
            new Author(1, "Yassine ben kacem", "2004-04-17"),
            new Author(2, "Karim hmdan", "2001-03-12"),
            new Author(3, "Ahmed kalouch", "2000-01-01")
    );

    public static Optional<Author> getAuthorById(Integer id){
        Optional<Author> author = authors
                .stream()
                .filter(a -> a.id.equals(id))
                .findAny();
        if(author.isEmpty()){
            return null;
        }
        return author;
    }

}
