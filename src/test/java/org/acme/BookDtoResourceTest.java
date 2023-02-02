package org.acme;

import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.acme.model.BookDto;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
class BookDtoResourceTest {

    @Test
    public void shouldReturnBook() {
        given()
                .get("/book/11")
                .then()
                .statusCode(200)
                .body("name", notNullValue())
                .body("author", notNullValue())
                .body("id", equalTo(11));
    }


    @Test
    public void shouldCreateBook() {
        var book = new BookDto(13L, "X", "y");
        given()
                .body(book)
                .contentType(MediaType.APPLICATION_JSON)
                .post("/book")
                .then()
                .statusCode(201)
                .header("location", equalTo("http://localhost:8081/book/" + book.getId()));

    }
}