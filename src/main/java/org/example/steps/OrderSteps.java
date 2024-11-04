package org.example.steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.example.models.Order;
import java.util.List;

import static org.example.clients.OrderClient.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;



public class OrderSteps {
    private static List<String> color;
    private static int track;
    private static List<String> orders;


    @Step("Создание заказа")
    public static ValidatableResponse createOrder() {
        Order order = Order.randomOrder(color);
        return createOrderClient(order);
    }

    @Step("Проверка, что тело ответа содержит track")
    public static void checkTrack(ValidatableResponse response) {
        response.assertThat().body(containsString("track"));
    }

    @Step("Отмена заказа, если был создан")
    public static void orderCancel() {
        if (track > 0) {
            String deleteOrder = "{\"track\":" + track + "}";
            cancelOrderClient(deleteOrder);
        }
    }
    @Step("Получение списка заказов")
    public static ValidatableResponse getOrdersList() {

        return getOrderClient();
    }

    @Step("Проверяем тело возвращения списка заказов")
    public static void checkOrdersNotNull(ValidatableResponse response) {
        response.assertThat().body("orders", notNullValue());

    }
}
