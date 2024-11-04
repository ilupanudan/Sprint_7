import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static org.example.steps.OrderSteps.checkOrdersNotNull;
import static org.example.steps.OrderSteps.getOrdersList;

public class OrderListTest {

    @Test
    @DisplayName("Получение списка заказов")
    public void getOrdersListTest() {
        ValidatableResponse response = getOrdersList();
        checkOrdersNotNull(response);
    }
}

