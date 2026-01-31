package testData;

import models.User;

public class TestData {
    public static final User DEFAULT_USER = User.builder()
            .username("john_doe")
            .firstName("John")
            .lastName("Doe")
            .email("john.doe@example.com")
            .password("password123")
            .phone("87479344214")
            .userStatus(0)
            .build();

    public static final User INVALID_USER = User.builder().build();
}
