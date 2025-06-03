import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTest {
    //GET
    @Test
    public void getRequestShouldReturnStatus200() { //
        given()
                //.log().all() // Логируем запрос
                .when()
                .get("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                .then()
                .log().all() // Логируем ответ
                .statusCode(200);
    }

    @Test
    public void getRequestShouldReturnExpectedUrl() { //
        given()
                .log().all()
                .when()
                .get("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                .then()
                .log().all()
                .body("url", containsString("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void getResponseBodyHasJsonWithRequestQueries() {
        given()
                .log().all()
                .when()
                .get("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                .then()
                .log().all()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    //POST
    @Test
    public void postRequestShouldReturnStatus200() {
        given()
                //.log().all()
                .body("test body")
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void postTextShouldBeReturnedInDataField() {
        given()
                //.log().all()
                .header("Content-Type", "text/plain")
                .body("{\n\"test\": \"value\"\n}")
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .log().all()
                .body("data", equalTo("{\n\"test\": \"value\"\n}"));
    }

    @Test
    public void postResponseBodyHasJsonWithFormData() {
        String requestBody = "{\"foo1\": \"bar1\", \"foo2\": \"bar2\"}";

        given()
                .log().all()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .log().all()
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"));
    }

    //PUT
    @Test
    public void putTextShouldBeReturnedInDataField() {
        given()
                //.log().all()
                .header("Content-Type", "text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("https://postman-echo.com/put")
                .then()
                .log().all()
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    //PATCH
    @Test
    public void patchTextShouldBeReturnedInDataField() {
        given()
                //.log().all()
                .header("Content-Type", "text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("https://postman-echo.com/patch")
                .then()
                .log().all()
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    //DELETE
    @Test
    public void deleteTextShouldBeReturnedInDataField() {
        given()
                //.log().all()
                .header("Content-Type", "text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("https://postman-echo.com/delete")
                .then()
                .log().all()
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}