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

    public BookDto castBookEntityToDto(BookEntity bookEntity) {
        BookDto bookDto = new BookDto();

        if (bookDto.getTitle() != null)
            bookDto.setTitle(bookEntity.getTitle().trim());

        if (bookDto.getEnter() != null)
            bookDto.setEnter(bookEntity.getEnter().trim());

        if (bookDto.getEvent() != null)
            bookDto.setEvent(bookEntity.getEvent().trim());

        if (bookDto.getNotes() != null)
            bookDto.setNotes(bookEntity.getNotes().trim());

        if (bookDto.getSerie() != null)
            bookDto.setSerie(bookEntity.getSerie().trim());

        if (bookDto.getAuthor() != null)
            bookDto.setAuthor(bookEntity.getAuthor().trim());

        if (bookDto.getAnnoPub() != 0)
            bookDto.setAnnoPub(bookEntity.getAnnoPub());
        if (bookDto.getDomCode() != null)
            bookDto.setDomCode(bookEntity.getDomCode().trim());

        if (bookDto.getCountry() != null)
            bookDto.setCountry(bookEntity.getCountry().trim());

        if (bookDto.getEdition() != null)
            bookDto.setEdition(bookEntity.getEdition().trim());

        if (bookDto.getFolleto() != null)
            bookDto.setFolleto(bookEntity.getFolleto().trim());

        if (bookDto.getColation() != null)
            bookDto.setColation(bookEntity.getColation().trim());

        if (bookDto.getIsbnCode() != null)
            bookDto.setIsbnCode(bookEntity.getIsbnCode().trim());

        if (bookDto.getLanguage() != null)
            bookDto.setLanguage(bookEntity.getLanguage().trim());

        if (bookDto.getDeweyCode() != null)
            bookDto.setDeweyCode(bookEntity.getDeweyCode().trim());

        if (bookDto.getTypeAuthor() != null)
            bookDto.setTypeAuthor(bookEntity.getTypeAuthor().trim());

        if (bookDto.getReferences() != null)
            bookDto.setReferences(bookEntity.getReferences().trim());

        if (bookDto.getPublication() != null)
            bookDto.setPublication(bookEntity.getPublication().trim());

        if (bookDto.getMentionResp() != null)
            bookDto.setMentionResp(bookEntity.getMentionResp().trim());

        if (bookDto.getClasification() != null)
            bookDto.setClasification(bookEntity.getClasification().trim());

        if (bookDto.getAnotherTitles() != null)
            bookDto.setAnotherTitles(bookEntity.getAnotherTitles().trim());

        if (bookDto.getAnotherAuthors() != null)
            bookDto.setAnotherAuthors(bookEntity.getAnotherAuthors().trim());

        return bookDto;
    }

    @Override
    public BookEntity udpateBook(BookDto bookDto) {
        BookEntity bookEntity = getBookByDomCode(bookDto.getDomCode().trim());
        System.out.println("ENTITYYYYYYYYYYYYYYYY: " + bookEntity.getTitle() );
        if (bookEntity != null) {

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

            this.bookRepository.save(bookEntity);
        }
        return bookEntity;
    }
}
