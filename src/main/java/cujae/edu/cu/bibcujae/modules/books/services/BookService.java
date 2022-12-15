package cujae.edu.cu.bibcujae.modules.books.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cujae.edu.cu.bibcujae.modules.books.dto.BookDto;
import cujae.edu.cu.bibcujae.modules.books.entities.BookEntity;
import cujae.edu.cu.bibcujae.modules.books.repositories.BookRepository;

@Service
public class BookService implements IBookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Page<BookEntity> getPagBooks(int pagination) {
        Pageable pag = PageRequest.of(0, pagination);
        return bookRepository.findAll(pag);
    }

    @Override
    public BookEntity getBookByDomCode(String domCode) {
        List<BookEntity> listBooks = getAllBooks();
        BookEntity bookFound = null;
        
        for (BookEntity bookEntity : listBooks) {
            if (bookEntity.getDomCode().trim().equalsIgnoreCase(domCode.trim())) {
                bookFound = bookEntity;
            }
        }
        return bookFound;
    }

    @Override
    public BookEntity createBook(BookDto bookDto) {
        BookEntity bookEntity = new BookEntity();

        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setEnter(bookDto.getEnter());
        bookEntity.setEvent(bookDto.getEvent());
        bookEntity.setNotes(bookDto.getNotes());
        bookEntity.setSerie(bookDto.getSerie());
        bookEntity.setAuthor(bookDto.getAuthor());
        bookEntity.setAnnoPub(bookDto.getAnnoPub());
        bookEntity.setDomCode(bookDto.getDomCode());
        bookEntity.setCountry(bookDto.getCountry());
        bookEntity.setEdition(bookDto.getEdition());
        bookEntity.setFolleto(bookDto.getFolleto());
        bookEntity.setColation(bookDto.getColation());
        bookEntity.setIsbnCode(bookDto.getIsbnCode());
        bookEntity.setLanguage(bookDto.getLanguage());
        bookEntity.setDeweyCode(bookDto.getDeweyCode());
        bookEntity.setTypeAuthor(bookDto.getTypeAuthor());
        bookEntity.setReferences(bookDto.getReferences());
        bookEntity.setPublication(bookDto.getPublication());
        bookEntity.setMentionResp(bookDto.getMentionResp());
        bookEntity.setClasification(bookDto.getClasification());
        bookEntity.setAnotherTitles(bookDto.getAnotherTitles());
        bookEntity.setAnotherAuthors(bookDto.getAnotherAuthors());

        BookEntity bookSave = bookRepository.save(bookEntity);

        return bookSave;
    }

    @Override
    public void deleteBook(String domCode) {
        BookEntity bookEntity = getBookByDomCode(domCode);
        if (bookEntity != null)
            bookRepository.delete(bookEntity);
    }
}
