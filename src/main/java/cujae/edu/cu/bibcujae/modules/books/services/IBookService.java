package cujae.edu.cu.bibcujae.modules.books.services;

import java.util.List;

import org.springframework.data.domain.Page;

import cujae.edu.cu.bibcujae.modules.books.dto.BookDto;
import cujae.edu.cu.bibcujae.modules.books.entities.BookEntity;

public interface IBookService {

    /*
     * Método para obtener todos los libros
     */
    List<BookEntity> getAllBooks();
    /*
     * Método para obtener libros hasta una cantidad determinada
     */
    Page<BookEntity> getPagBooks(int pagination);

    /*
     * Método para obtener un libro por código de domicilio
     */
    BookEntity getBookByDomCode(String domCode);

    /*
     * Método para crear un nuevo libro
     */
    BookEntity createBook(BookDto bookDto);

    void deleteBook(String domCode);
}
