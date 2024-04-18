package com.Api_Neo4j_GraphQl.demo.graphqlConfiguration;

import com.Api_Neo4j_GraphQl.demo.resolver.BookMutationResolver;
import com.Api_Neo4j_GraphQl.demo.resolver.BookQueryResolver;

import graphql.kickstart.tools.SchemaParser;
import graphql.schema.GraphQLSchema;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {

    @Bean
    public GraphQLSchema graphQLSchema(BookQueryResolver bookQueryResolver, BookMutationResolver bookMutationResolver) {
        return SchemaParser.newParser()
                .file("graphql/book.graphqls")
                .resolvers(bookQueryResolver, bookMutationResolver)
                .build()
                .makeExecutableSchema();
    }
}