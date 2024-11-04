import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;


import static org.example.Constants.*;
import static org.example.steps.CourierSteps.*;


public class CourierCreateTests {

    @After
    public void tearDown() {
        deleteCourier();
    }

    @Test
    @DisplayName("Курьера можно создать;")
    public void courierCreate() {
        ValidatableResponse response = createCourier();
        checkStatusCode(response, SUCCES_CREATED);
        checkMessageContainsAnswer(response, CREATE_SUCCES_ANSWER);
    }

    @Test
    @DisplayName("Нельзя создать двух одинаковых курьеров;")

    public void courierDoubleCreate() {
        ValidatableResponse response;
        createCourier();
        response = createSameCourier();
        checkStatusCode(response, CONFLICT);

    }


    @Test
    @DisplayName("Если создать пользователя с логином, который уже есть, возвращается ошибка.")
    @Description("По документации message должен быть: \"Этот логин уже используется\", по факту: \"Этот логин уже используется. Попробуйте другой.\"")
    public void courierDoubleCreateCorrectAnswer() {
        createCourier();
        ValidatableResponse response = createCourierWithSameLogin();
        checkMessage(response, LOGIN_ALREADY_USED);

}
    @Test
    @DisplayName("Чтобы создать курьера, нужно передать в ручку все обязательные поля; (Создаем без логина)")
    public void courierCreateWithoutLogin() {
        ValidatableResponse response = createCourierWithoutLogin();
        checkStatusCode(response, BAD_REQUEST);
        checkMessage(response, NOT_ENOUGH_DATA_FOR_CREATE);
    }

    @Test
    @DisplayName("Чтобы создать курьера, нужно передать в ручку все обязательные поля; (Создаем без имени)")
    @Description ("Падает, т.к возвращается статус-код 201(Успешно создается Курьер). В документации не указано, какие поля являются обязательными")
    public void courierCreateWithoutFirstName() {
        ValidatableResponse response = createCourierWithoutFirstName();
        checkStatusCode(response, BAD_REQUEST);
        checkMessage(response, NOT_ENOUGH_DATA_FOR_CREATE);
    }

    @Test
    @DisplayName("Чтобы создать курьера, нужно передать в ручку все обязательные поля; (Создаем без пароля)")
    public void courierCreateWithoutPassword() {
        ValidatableResponse response = createCourierWithoutPassword();
        checkStatusCode(response, BAD_REQUEST);
        checkMessage(response, NOT_ENOUGH_DATA_FOR_CREATE);
    }

    }