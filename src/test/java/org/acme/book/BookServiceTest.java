package org.acme.book;

import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.acme.model.Book;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@QuarkusTest
class BookServiceTest {
    @Inject
    BookService bookService;

    @Test
    public void shouldCreateBooK() {
        var expectedBook = new Book();
        expectedBook.id = 10L;
        expectedBook.name = "Book1";
        expectedBook.author = "ALi";

        PanacheMock.mock(Book.class);

        when(Book.findById(expectedBook.id)).thenReturn(expectedBook);
        var actualBook = bookService.getById(10L);

        assertEquals(expectedBook.id, actualBook.getId());
        assertEquals(expectedBook.name, actualBook.getName());
        assertEquals(expectedBook.author, actualBook.getAuthor());
    }
}