package pl.dan.qa.qaapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.dan.qa.qaapi.service.UserService;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static com.google.common.truth.Truth.assertThat;

@DisplayName("ApiTest")
public class ApiTest {

    @DisplayName("First test from mocky.io")
    @Test
    public void firstApiTest(){
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name",equalTo("Piotr"))
                .body("surname", equalTo("Kowalski"));

    }

    @DisplayName("User with device test")
    @Test
    public void userDeviceTest(){
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .body("[0].imie",notNullValue())
                .body("[0].imie", equalTo("Piotr"))
                .body("[0].nazwisko",notNullValue())
                .body("[0].nazwisko", equalTo("Kowalski"))
                .body("[0].device[0].type",notNullValue())
                .body("[0].device[0].type", equalTo("computer"));
//                .body("[0].device[0].model[0].produce", equalTo("dell"));
    }

    @DisplayName("User with device by model")
    @Test
    public void userDeviceByModelTest(){
        List<User> listUser = RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("",User.class);

        System.out.println(listUser.toString());

        assertThat(listUser.get(0).imie.equals("Piotr"));
    }

    @DisplayName("User with device by model")
    @Test
    public void SplitResponse(){
//        Response response = RestAssured
//                .given()
//                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
//                .andReturn();

        Response response = UserService.returnUserResponse();
        List<User> users = UserService.getUsers();

        assertThat(response.statusCode()).isEqualTo(200);

        assertThat(users.get(0).imie).isEqualTo("Piotr");
        assertThat(users.size()).isEqualTo(2);
        assertThat(users.get(0).nazwisko).isEqualTo("Kowalski");
        assertThat(users.get(0).device.get(0).type).isEqualTo("computer");
        assertThat(users.get(0).device.get(0).deviceModel.get(0).produce).isEqualTo("dell");
        assertThat(users.get(0).device.get(0).deviceModel.get(0).screenSize).isEqualTo(17);
        assertThat(users.get(0).device.size()).isEqualTo(2);

    }

}
