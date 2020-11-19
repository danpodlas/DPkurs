package pl.dan.qa.qaapi.service;

import io.restassured.response.Response;
import pl.dan.qa.qaapi.User;

import java.util.List;

public class UserService extends Service {

    private static final String USER_HOST = "http://www.mocky.io/v2/5a6a58222e0000d0377a7789";

    public static Response returnUserResponse() {
        return returnResponse(USER_HOST);
    }

    public static List<User> getUsers(){
        return returnResponseUnPack(USER_HOST).getList("", User.class);
    }

}
