# Documentation API

## Requêtes GraphQL

### Récupérer tous les livres

```graphql
query {
  books {
    id
    title
    author
    publicationYear
    genre
  }
}
```

### Récupérer un livre par son ID

```graphql
query {
  bookById(id: 1) {
    id
    title
    author
    publicationYear
    genre
  }
}
```

### Récupérer un livre par son titre

```graphql
query {
  bookByTitle(title: "Le Petit Prince") {
    id
    title
    author
    publicationYear
    genre
  }
}
```

### Ajouter un nouveau livre

```graphql
mutation {
  addBook(
    title: "To Kill a Mockingbird"
    author: "Harper Lee"
    publicationYear: 1960
    genre: "Fiction"
  ) {
    title
    author
    publicationYear
    genre
  }
}
```

### Supprimer un livre par son ID

```graphql
mutation {
  deleteBookById(id: 1)
}
```

## Requêtes JSON

### Récupérer tous les livres

```json
{
    "query": "{
        books {
            id
            title
            author
            publicationYear
            genre
        }
    }"
}
```

### Récupérer un livre par son ID

```json
{
    "query": "{
        bookById(id: 1) {
            id
            title
            author
            publicationYear
            genre
        }
    }"
}
```

### Récupérer un livre par son titre

```json
{
    "query": "{
        bookByTitle(title: \"Le Petit Prince\") {
            id
            title
            author
            publicationYear
            genre
        }
    }"
}
```

### Ajouter un nouveau livre

```json
{
    "query": "mutation {
        addBook(title: \"1984\", author: \"George Orwell\", publicationYear: 1949, genre: \"Dystopie\") {
            id
            title
            author
            publicationYear
            genre
        }
    }"
}
```

### Supprimer un livre par son ID

```json
{
    "query": "mutation {
        deleteBookById(id: 1)
    }"
}
```

# Structure de l'Entité Book

L'entité `Book` représente un livre dans la base de données. Voici la structure de l'entité :

- `id` : L'identifiant unique du livre.
- `title` : Le titre du livre.
- `author` : L'auteur du livre.
- `publicationYear` : L'année de publication du livre.
- `genre` : Le genre du livre.

## Exemple d'Objet Book

Voici un exemple d'objet `Book` :

```json
{
  "id": 1,
  "title": "1984",
  "author": "George Orwell",
  "publicationYear": 1949,
  "genre": "Dystopie"
}
```

Cette structure d'entité est utilisée pour les opérations de création, de lecture, de mise à jour et de suppression dans l'API.

## L'importance du fichier `book.graphqls`

Le fichier `book.graphqls` agit comme un plan détaillé de notre API GraphQL.  
Il définit les types de données disponibles, tels que `Book`, ainsi que les champs associés à chaque type.  
À titre d'exemple, un `Book` possède un `id`, un `title`, un `author`, une `publicationYear` et un `genre`.

Ce fichier spécifie également les actions que les clients peuvent effectuer via notre API.  
Ils ont la possibilité de récupérer tous les livres, de demander un livre spécifique par son ID ou d'ajouter un nouveau livre.  
Ces actions sont respectivement appelées requêtes et mutations.

En centralisant ces informations dans `book.graphqls`, nous rendons notre API plus compréhensible et accessible.  
Ce fichier fait office de manuel de référence pour notre API.  
Toute modification apportée à notre API doit être répercutée dans ce fichier pour maintenir une documentation à jour.

Les outils de développement et les IDE peuvent exploiter `book.graphqls` pour faciliter le travail des développeurs avec notre API.  
Ils sont capables de suggérer des champs et des requêtes pertinents, de valider la syntaxe des requêtes et même d'afficher la documentation directement dans l'environnement de développement.

En résumé, `book.graphqls` joue un rôle essentiel dans la définition, la documentation et la maintenance de notre API.

## L'importance de `GraphqlConfiguration.class`

Le fichier `GraphqlConfiguration.class` facilite la configuration et la personnalisation de notre API.

### Fonctionnement

- **Définition des Schémas et Résolveurs** :  
  Ce fichier définit les types de données disponibles et la manière de répondre aux requêtes des clients.
- **Personnalisation** :  
  Il permet d'adapter le comportement de notre API, notamment le traitement des requêtes et la gestion des erreurs.
- **Intégration avec Spring Boot** :  
  `GraphqlConfiguration.class` s'intègre de manière transparente avec Spring Boot, simplifiant ainsi l'utilisation de GraphQL dans notre application.
- **Documentation et Support** :  
  L'analyse de ce fichier permet de comprendre la configuration et le fonctionnement de notre API.

## L'importance des Resolvers

Les fichiers `BookMutationResolver.java` et `BookQueryResolver.java` sont essentiels pour gérer les requêtes et les mutations de notre API GraphQL.  
Ils servent d'intermédiaires entre les demandes des clients et les actions effectuées sur nos données via Spring Data JPA.

Voici pourquoi ils sont cruciaux :

### Gestion des Actions

- **`BookMutationResolver.java`** :  
  Ce fichier définit les méthodes pour réaliser des mutations, c'est-à-dire des opérations qui modifient les données, comme l'ajout d'un nouveau livre.
- **`BookQueryResolver.java`** :  
  Ce fichier définit les méthodes pour exécuter des requêtes, c'est-à-dire des opérations qui récupèrent des données sans les modifier, comme la recherche d'un livre par son titre.

### Structure et Adaptabilité

La séparation des actions de lecture et d'écriture dans des fichiers distincts offre une structure claire et organisée.  
Il simplifie la maintenance et l'évolution de notre API.  
L'ajout ou la modification de fonctionnalités est ainsi facilité, car nous savons précisément où intervenir.

### Interaction avec la Couche de Service

Les resolvers communiquent étroitement avec la couche de service de notre application, qui gère la logique métier et les interactions avec la base de données via Spring Data JPA.

Cette approche permet de séparer les responsabilités :  
les resolvers se concentrent sur la gestion des requêtes et des mutations, tandis que la couche de service se charge de la logique métier.

### Documentation et Assistance

L'examen des méthodes dans `BookMutationResolver.java` et `BookQueryResolver.java` permet aux développeurs de comprendre rapidement les opérations disponibles et leur implémentation.  
Il facilite le support et la maintenance de l'API, ainsi que l'intégration de nouvelles fonctionnalités ou technologies.
