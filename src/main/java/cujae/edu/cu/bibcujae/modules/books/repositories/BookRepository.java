package cujae.edu.cu.bibcujae.modules.books.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import cujae.edu.cu.bibcujae.modules.books.entities.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

}