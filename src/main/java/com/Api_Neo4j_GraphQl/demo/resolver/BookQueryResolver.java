package com.Api_Neo4j_GraphQl.demo.resolver;

import com.Api_Neo4j_GraphQl.demo.Entities.Book;
import com.Api_Neo4j_GraphQl.demo.service.BookService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookQueryResolver implements GraphQLQueryResolver {
    private static final Logger logger = LoggerFactory.getLogger(BookQueryResolver.class);

    private final BookService bookService;

    public BookQueryResolver(BookService bookService) {
        this.bookService = bookService;
        logger.info("BookQueryResolver initialized");
    }

    // Method to find a book by its title using a Cypher query
    public List<Book> bookByTitle(String title) {
        return bookService.findBookByTitle(title);
    }

    // Method to retrieve all books using a Cypher query
    public List<Book> books() {
        logger.info("Successful call to books() method");
        List<Book> books = bookService.findAll();
        if (!books.isEmpty()) {
            logger.info("Found {} books", books.size());
        } else {
            logger.info("No books found");
        }
        return books;
    }

    // Method to find a book by its ID
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