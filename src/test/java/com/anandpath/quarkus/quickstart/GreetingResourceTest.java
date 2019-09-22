package com.anandpath.quarkus.quickstart;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }
    @Test
    public void greetingEndpoint() {
    	String uuid = UUID.randomUUID().toString();
    	given()
    	.when().get("/greeting/" + uuid)
    	.then()
    	.statusCode(200)
    	.body(is("Hello " + uuid + " \n"));
    }

}