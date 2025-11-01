package com.example.api.tests.users;

import com.bookStore.api.clients.*;
import com.bookStore.api.dto.User;
import com.example.api.tests.BaseApiTest;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CreateUserTests extends BaseApiTest {
    private final UsersApi users = new UsersApi();

    @Test
    void should_create_valid_user() {
        var payload = User.builder()
                .name("Test User")
                .email("test.user@example.com")
                .build();

        var resp = users.createUserRaw(payload);

        assertThat(resp.statusCode()).isEqualTo(201);
        resp.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/UserSchema.json"));
        assertThat(resp.jsonPath().getString("name")).isEqualTo("Test User");
    }
}

