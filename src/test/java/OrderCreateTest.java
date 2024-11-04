import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;
import static org.example.Constants.SUCCES_CREATED;
import static org.example.steps.CourierSteps.checkStatusCode;
import static org.example.steps.OrderSteps.*;

@RunWith(Parameterized.class)
public class OrderCreateTest {

    private final List<String> color;

    public OrderCreateTest(List<String> color) {
        this.color = color;
    }

    @After
    public void cancelOrder(){
        orderCancel();
    }

    @Parameterized.Parameters
    public static Object[][] color() {
        return new Object[][]{
                {List.of("BLACK")},
                {List.of("GRAY")},
                {List.of("BLACK", "GRAY")},
                {List.of()},
        };
    }
    @Test
    @DisplayName("Создание заказа.")
    public void createOrderTest() {
        ValidatableResponse response = createOrder();
        checkStatusCode(response, SUCCES_CREATED);
        checkTrack(response);
    }
}


