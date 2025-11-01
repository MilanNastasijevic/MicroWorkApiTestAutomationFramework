package com.example.api.tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;

public abstract class BaseApiTest {
    @BeforeAll
    static void beforeAll() {
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Step("Asserting common post-conditions")
    protected void commonAssertions() {
        // place for cross-cutting checks if needed
    }
}
