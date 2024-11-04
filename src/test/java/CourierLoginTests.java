import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.example.Constants.*;
import static org.example.steps.CourierSteps.*;



public class CourierLoginTests  {

    @Before
    public void createAndLoginCourier(){
        createCourier();
    }

    @After
    public void tearDown() {
        deleteCourier();

    }


    @Test
    @DisplayName("Курьер может авторизоваться;")
    public void courierLogin() {
        ValidatableResponse response = loginCourier();
        checkStatusCode(response, OK);
    }


    @Test
    @DisplayName("Для авторизации нужно передать все обязательные поля; (без пароля)")
    @Description("Баг. Падает по timeout если передать password : null")
    public void loginWithoutPasswordTest() {
        ValidatableResponse response = loginWithoutPassword();
        checkStatusCode(response, BAD_REQUEST);
        checkMessage(response, NOT_ENOUGH_DATA_FOR_LOGIN);
    }

    @Test
    @DisplayName("Для авторизации нужно передать все обязательные поля; (без логина)")
    public void loginWithoutLoginTest() {
        ValidatableResponse response = loginWithoutLogin();
        checkStatusCode(response, BAD_REQUEST);
        checkMessage(response, NOT_ENOUGH_DATA_FOR_LOGIN);
    }

    @Test
    @DisplayName("Cистема вернёт ошибку, если неправильно указать логин или пароль; (некорректный логин)")
    public void loginWithWrongLoginTest() {
        ValidatableResponse response = loginWithWrongLogin();
        checkStatusCode(response, NOT_FOUND);
        checkMessage(response, ACCOUNT_NOT_FOUND);
    }

    @Test
    @DisplayName("Cистема вернёт ошибку, если неправильно указать логин или пароль; (некорректный пароль)")
    public void loginWithWrongPasswordTest() {
        ValidatableResponse response = loginWithWrongPassword();
        checkStatusCode(response, NOT_FOUND);
        checkMessage(response, ACCOUNT_NOT_FOUND);
    }



    }


