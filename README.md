# Music Database Project (Alura)

Este é um projeto para registrar nomes de músicas, seus autores e armazená-los em um banco de dados. Além disso, oferece a funcionalidade de buscar músicas por autor.

## Funcionalidades

- Registrar nomes de músicas e seus autores no banco de dados.
- Buscar músicas por autor.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Banco de Dados (ex: MySQL, PostgreSQL, etc.)

## Exemplo de Uso

Para buscar músicas por autor, você pode utilizar o método `buscaMusicaPorArtista` no `ArtistaRepository`. Aqui está um exemplo de como utilizá-lo:

```java
@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    Optional<Artista> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a.nome ILIKE %:nome% ")
    List<Musica> buscaMusicaPorArtista(String nome);
}
