package com.bookStore.api.clients;

import com.bookStore.api.core.Json;
import com.bookStore.api.core.RequestSpecFactory;
import com.bookStore.api.dto.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersApi {
    public Response getUserRaw(String id) {
        return given(RequestSpecFactory.withAuth())
                .when().get("/users/{id}", id)
                .then().extract().response();
    }

    public User getUser(String id) {
        return Json.mapper().convertValue(getUserRaw(id).as(User.class), User.class);
    }

    public Response createUserRaw(User payload) {
        return given(RequestSpecFactory.withAuth())
                .body(payload)
                .when().post("/users")
                .then().extract().response();
    }
}




