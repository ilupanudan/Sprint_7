package org.example.clients;

import io.restassured.response.ValidatableResponse;
import org.example.models.Courier;
import org.example.models.CourierCreds;

import static io.restassured.RestAssured.given;
import static org.example.Constants.*;


public class CourierClient {

    public static ValidatableResponse createCourierClient(Courier courier) {
        return given()
                .baseUri(BASE_URI)
                .header("Content-type", "application/json")
                .body(courier)
                .when()
                .post(CREATE_COURIER_PATH)
                .then().log().all();

    }

    public static ValidatableResponse loginClient(CourierCreds courierCreds) {
        return given()
                .baseUri(BASE_URI)
                .header("Content-type", "application/json")
                .body(courierCreds)
                .when()
                .post(COURIER_LOGIN_PATH)
                .then().log().all();
    }

    public static ValidatableResponse deleteClient(int id) {
        String deleteCourier = "{\"id\":\"" + id + "\"}";
        return given()
                .baseUri(BASE_URI)
                .header("Content-type", "application/json")
                .body(deleteCourier)
                .when()
                .delete(CREATE_COURIER_PATH +"/"+ id)
                .then().log().all();
    }
}
