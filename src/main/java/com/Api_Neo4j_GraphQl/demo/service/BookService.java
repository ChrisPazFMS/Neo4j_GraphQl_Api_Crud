package com.Api_Neo4j_GraphQl.demo.service;

import com.Api_Neo4j_GraphQl.demo.Entities.Book;
import com.Api_Neo4j_GraphQl.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    // Méthode pour trouver un livre par son titre avec Spring Data JPA
    public List<Book> findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    // Méthode pour trouver un livre par son titre en utilisant une requête Cypher
    // public List<Book> findBookByTitle(String title) {
    // return bookRepository.findBookByTitle(title);
    // }

    // Méthode pour récupérer tous les livres en utilisant une requête Cypher
    // public List<Book> findAllBooks() {
    // return bookRepository.findAllBooks();
    // }

    // Méthode pour récupérer tous les livres avec Spring Data JPA
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    // Méthode pour récupérer un livre par son ID avec Spring Data JPA
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    // Méthode pour sauvegarder un livre
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    // Méthode pour supprimer un livre
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}