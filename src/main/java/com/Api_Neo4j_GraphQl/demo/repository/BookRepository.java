package com.Api_Neo4j_GraphQl.demo.repository;

import com.Api_Neo4j_GraphQl.demo.Entities.Book;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends Neo4jRepository<Book, Long> {

    // Méthode pour trouver un livre par son titre de Spring Data JPA
    List<Book> findByTitle(String title);

    // Méthode pour trouver un livre par son titre en utilisant une requête Cypher
    // @Query("MATCH (b:Book {title: $title}) RETURN b")
    // Optional<Book> findBookByTitle(String title);

    // Méthode pour récupérer tous les livres en utilisant une requête Cypher
    // @Query("MATCH (b:Book) RETURN b")
    // List<Book> findAllBooks();

}