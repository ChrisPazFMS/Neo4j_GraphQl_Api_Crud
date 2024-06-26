package com.Api_Neo4j_GraphQl.demo.resolver;

import com.Api_Neo4j_GraphQl.demo.Entities.Book;
import com.Api_Neo4j_GraphQl.demo.service.BookService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class BookMutationResolver implements GraphQLMutationResolver {

    private final BookService bookService;

    public BookMutationResolver(BookService bookService) {
        this.bookService = bookService;
    }

    // Method to add a book
    public Book addBook(String title, String author, int publicationYear, String genre) {
        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setAuthor(author);
        newBook.setPublicationYear(publicationYear);
        newBook.setGenre(genre);
        return bookService.save(newBook);
    }

    // Method to delete a book by its ID
    public Boolean deleteBookById(Long id) {
        bookService.deleteBookById(id);
        return true; // Return true if successful
    }
}