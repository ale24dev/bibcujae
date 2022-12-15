package cujae.edu.cu.bibcujae.modules.books.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import cujae.edu.cu.bibcujae.modules.books.dto.BookDto;
import cujae.edu.cu.bibcujae.modules.books.entities.BookEntity;
import cujae.edu.cu.bibcujae.modules.books.services.BookService;

@RestController
@RequestMapping("bibcujae/api/v1/books")
public class BookController {
    
    @Autowired
    BookService bookService;

    @GetMapping("/")
    public ResponseEntity<List<BookEntity>> getAllBooks() {

        List<BookEntity> listBooks = bookService.getAllBooks();
        return ResponseEntity.ok(listBooks);
    }

    @GetMapping("/pag/{pagination}")
    public ResponseEntity<Page<BookEntity>> getPagBooks(@PathVariable int pagination) {

        Page<BookEntity> listBooks = bookService.getPagBooks(pagination);
        return ResponseEntity.ok(listBooks);
    }

    @GetMapping("/domCode/{domCode}")
    public ResponseEntity<BookEntity> getBookByDomCode(@PathVariable String domCode) {
        BookEntity book = bookService.getBookByDomCode(domCode);
        return ResponseEntity.ok(book);
    }

    @PostMapping("/")
    public ResponseEntity<BookEntity> createBook(@RequestBody BookDto bookDto) {
        BookEntity book = bookService.createBook(bookDto);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/domCode/{domCode}")
    public ResponseEntity<String> createBook(@PathVariable String domCode) {
        bookService.deleteBook(domCode);
        return ResponseEntity.ok("Libro eliminado correctamente");
    }
}
