package com.Api_Neo4j_GraphQl.demo.repository;

import com.Api_Neo4j_GraphQl.demo.Entities.Book;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends Neo4jRepository<Book, Long> {

    // Method to find a book by its title from Spring Data JPA
    List<Book> findByTitle(String title);

    // Method to find a book by its title using a Cypher query
    // @Query("MATCH (b:Book {title: $title}) RETURN b")
    // Optional<Book> findBookByTitle(String title);

    // Method to retrieve all books using a Cypher query
    // @Query("MATCH (b:Book) RETURN b")
    // List<Book> findAllBooks();

}