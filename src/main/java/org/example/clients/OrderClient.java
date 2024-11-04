package org.example.clients;

import io.restassured.response.ValidatableResponse;
import org.example.models.Order;

import static io.restassured.RestAssured.given;
import static org.example.Constants.*;

public class OrderClient {
    public static ValidatableResponse createOrderClient(Order order) {
        return given()
                .baseUri(BASE_URI)
                .header("Content-type", "application/json")
                .body(order)
                .when()
                .post(ORDERS_PATH)
                .then().log().all();
    }

    public static ValidatableResponse cancelOrderClient(String deleteOrder) {
        return given()
                .baseUri(BASE_URI)
                .header("Content-type", "application/json")
                .body(deleteOrder)
                .when()
                .put(CANCEL_ORDER_PATH)
                .then().log().all();

    }

    public static ValidatableResponse getOrderClient() {
        return given()
                .baseUri(BASE_URI)
                .header("Content-type", "application/json")
                .when()
                .get(ORDERS_PATH)
                .then().log().all();

    }
}