package org.acme.book;


import org.acme.model.BookDto;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/book")
public class BookResource {

    @Inject
    BookService bookService;

    @GET
    @Path("/{bookId}")
    @Produces(MediaType.APPLICATION_JSON)
    public BookDto getById(Long bookId) {
        return bookService.getById(bookId);
    }

    @GET
    @Path("/byName/{bookName}")
    @Produces(MediaType.APPLICATION_JSON)
    public BookDto getById(String bookName) {
        return bookService.getByName(bookName);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookDto> getAllBooks() {
        return bookService.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBook(BookDto bookDto) {
        var bookId = bookService.createBook(bookDto);
        return Response.created(URI.create("/book/" + bookId)).build();
    }
}
