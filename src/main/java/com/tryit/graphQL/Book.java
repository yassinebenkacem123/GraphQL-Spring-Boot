package com.tryit.graphQL;

import java.util.Arrays;
import java.util.List;

public record Book(
        Integer id,
        String name,
        Integer pageCount,
        String description
) {
    public static List<Book> books = Arrays.asList(
            new Book(1, "Quran", 320, "best book to read in the world"),
            new Book(2, "From poverty to power", 320, "If you want to make your life better read it"),
            new Book(3, "Grow rich with peace of mind", 20, "This book will help u to be rich but with peace of mind")
    );
}
