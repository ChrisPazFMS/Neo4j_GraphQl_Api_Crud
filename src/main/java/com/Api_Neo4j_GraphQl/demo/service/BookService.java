package com.Api_Neo4j_GraphQl.demo.service;

import com.Api_Neo4j_GraphQl.demo.Entities.Book;
import com.Api_Neo4j_GraphQl.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Method to find a book by its title with Spring Data JPA
    public List<Book> findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    // Method to find a book by its title using a Cypher query
    // public List<Book> findBookByTitle(String title) {
    // return bookRepository.findBookByTitle(title);
    // }

    // Method to retrieve all books using a Cypher query
    // public List<Book> findAllBooks() {
    // return bookRepository.findAllBooks();
    // }

    // Method to retrieve all books with Spring Data JPA
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    // Method to retrieve a book by its ID with Spring Data JPA
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    // Method to save a book
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    // Method to delete a book
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}