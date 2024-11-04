package org.example.steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.example.models.Courier;
import org.example.models.CourierCreds;


import static org.example.Constants.CONFLICT;
import static org.example.clients.CourierClient.createCourierClient;
import static org.example.clients.CourierClient.loginClient;
import static org.hamcrest.CoreMatchers.equalTo;



import org.example.clients.CourierClient;


public class CourierSteps {
    public static Courier courier;
    public static int id;
    public static CourierCreds courierCreds;

    @Step("Создание курьера")
    public static ValidatableResponse createCourier() {
        courier = Courier.randomCourier();
        return createCourierClient(courier);
    }

    @Step("Проверка статускода")
    public static void checkStatusCode(ValidatableResponse response, int statusCode) {
        response.assertThat().statusCode(statusCode);
    }

    @Step("Проверка месседж")
    public static void checkMessage(ValidatableResponse response, String expectedMessage) {
        response.assertThat().body("message", equalTo(expectedMessage));
    }

    @Step("Проверка месседж на наличие ответа")
    public static void checkMessageContainsAnswer(ValidatableResponse response, String expectedMessage) {
        response.assertThat().body(equalTo(expectedMessage));
    }

    @Step("Логин курьера")
    public static ValidatableResponse loginCourier() {
        courierCreds = CourierCreds.from(courier);
        return loginClient(courierCreds);
    }


    @Step("Удаление курьера")
    public static void deleteCourier() {
        if (id != 0) {
            loginCourier();
            CourierClient.deleteClient(id);
        }
    }

    @Step("Попытка создать второго курьера с такими же параметрами, как у первого")
    public static ValidatableResponse createSameCourier() {
        Courier same = courier;
        return CourierClient.createCourierClient(same);
    }

    @Step("Создаем курьера без логина")
    public static ValidatableResponse createCourierWithoutLogin() {
        return CourierClient.createCourierClient(Courier.withoutLogin());
    }

    @Step("Создаем курьера без пароля")
    public static ValidatableResponse createCourierWithoutPassword() {
        return CourierClient.createCourierClient(Courier.withoutPassword());
    }

    @Step("Создаем курьера без имени")
    public static ValidatableResponse createCourierWithoutFirstName() {
        return CourierClient.createCourierClient(Courier.withoutFirstName());
    }

    @Step("Создаем второго курьера с таким же логином")
    public static ValidatableResponse createCourierWithSameLogin() {
        Courier sameCourier = new Courier(courier.getLogin(), courier.getPassword(), Courier.randomCourier().getFirstName());
        ValidatableResponse response = CourierClient.createCourierClient(sameCourier)
                .assertThat().statusCode(CONFLICT);
        return response;
    }

    @Step("Попытка логина без пароля")
    public static ValidatableResponse loginWithoutPassword() {
        CourierCreds badCourier = CourierCreds.withoutPassword(courier);
        return loginClient(badCourier);
    }

    @Step("Попытка логина без логина")
    public static ValidatableResponse loginWithoutLogin() {
        CourierCreds badCourier = CourierCreds.withoutLogin(courier);
        return loginClient(badCourier);
    }

    @Step("Попытка логина с некорректным логином")
    public static ValidatableResponse loginWithWrongLogin() {
        CourierCreds badCourier = CourierCreds.randomLoginCorrectPassword(courier);
        return loginClient(badCourier);
    }

    @Step("Логин с некорректным паролем")
    public static ValidatableResponse loginWithWrongPassword() {
        CourierCreds badCourier = CourierCreds.randomPasswordCorrectLogin(courier);
        return loginClient(badCourier);
    }

}

