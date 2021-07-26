package ehcruz.com.github.video.controller;

import static io.restassured.RestAssured.given;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class VideoControllerTest {

    @Test
    void getVideosTest() {
        given()
                .when().get("/videos")
                .then()
                .statusCode(200);
    }

    @Test
    void getSingleVideoByIdTest() {
        given()
                .pathParam("id", 1)
                .when().get("/videos/{id}")
                .then()
                .statusCode(200);
    }

    @Test
    void postNewVideo() {
        given()
                .pathParam("id", 1)
                .when().get("/videos/{id}")
                .then()
                .statusCode(200);
    }

}
