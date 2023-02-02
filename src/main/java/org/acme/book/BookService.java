package org.acme.book;

import org.acme.person.PersonRepository;
import org.acme.model.Book;
import org.acme.model.BookDto;
import org.acme.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class BookService {

    public BookDto getById(Long bookId) {
//        return new BookDto(bookId, "Book1", "Milad");
        Book book = Book.findById(bookId);
        return new BookDto(book.id, book.name, book.author);
    }

    public BookDto getByName(String name) {
        Book book = Book.findByName(name);
        return new BookDto(book.id, book.name, book.author);
    }

    public List<BookDto> getAll() {
        /*var book1 = new BookDto(1L, "Book1", "Milad");
        var book2 = new BookDto(2L, "Book2", "Hasan");
        return List.of(book1, book2);
        */
        List<Book> books = Book.listAll();
        return books.stream()
                .map(book -> new BookDto(book.id, book.name, book.author))
                .collect(Collectors.toList());
    }

    @Transactional
    public Long createBook(BookDto bookDto) {
        var bookEntity = new Book();
        bookEntity.name = bookDto.getName();
        bookEntity.author = bookDto.getAuthor();

        bookEntity.persist();

        return bookEntity.id;
    }
}
