package com.Api_Neo4j_GraphQl.demo.resolver;

import com.Api_Neo4j_GraphQl.demo.Entities.Book;
import com.Api_Neo4j_GraphQl.demo.service.BookService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookQueryResolver implements GraphQLQueryResolver {
    private static final Logger logger = LoggerFactory.getLogger(BookQueryResolver.class);

    private final BookService bookService;

    public BookQueryResolver(BookService bookService) {
        this.bookService = bookService;
        logger.info("BookQueryResolver initialized");
    }

    // Méthode pour trouver un livre par son titre en utilisant une requête Cypher
    public List<Book> bookByTitle(String title) {
        return bookService.findBookByTitle(title);
    }

    public List<Book> books() {
        logger.info("Appel réussi à la méthode books()");
        List<Book> books = bookService.findAll();
        if (!books.isEmpty()) {
            logger.info("Found {} books", books.size());
        } else {
            logger.info("No books found");
        }
        return books;
    }

    public Book bookById(Long id) {
        logger.info("Fetching book with ID: {}", id);
        Book book = bookService.findById(id).orElse(null);
        if (book != null) {
            logger.info("Found book: {}", book.getTitle());
        } else {
            logger.warn("No book found with ID: {}", id);
        }
        return book;
    }
}