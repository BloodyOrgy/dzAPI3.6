package ru.netology;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostmanEchosTest {
    @Test
    void shouldReturnSendData(){
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Welcome")
                .when().log().all()
                .post("/post")
                .then().log().all()
                .statusCode(200)
                .body("data", org.hamcrest.Matchers.equalTo("Welcome"));        ;
    }
}
