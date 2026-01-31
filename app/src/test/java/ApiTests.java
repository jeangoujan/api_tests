
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import controllers.UserController;
import io.restassured.response.Response;
import models.User;
import models.AddUserResponse;
import static testData.TestData.DEFAULT_USER;


public class ApiTests {
    UserController userController = new UserController();

    @Test
    void createUserControllerTest(){
        // User user = new User( // Constructor pattern
        //     0,
        //     "john_doe",
        //     "John",
        //     "Doe",
        //     "john.doe@example.com",
        //     "password123",
        //     "87479344214",
        //     0
        //);
        // User  userBuilder = User.builder() // Builder pattern
        //     .id(0)
        //     .username("john_doe")
        //     .firstName("John")
        //     .lastName("Doe")
        //     .email("john.doe@example.com")
        //     .password("password123")
        //     .phone("87479344214")
        //     .userStatus(0)
        //     .build();
        User user = DEFAULT_USER;
        
        Response response = userController.createUser(user);
        AddUserResponse createdUserResponse = response.as(AddUserResponse.class);

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(200, createdUserResponse.getCode());
        Assertions.assertEquals("unknown", createdUserResponse.getType());
        Assertions.assertFalse(createdUserResponse.getMessage().isEmpty());

    }
}
