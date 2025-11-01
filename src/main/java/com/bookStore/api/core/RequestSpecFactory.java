package com.bookStore.api.core;

import com.bookStore.api.config.TestConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.filter.log.LogDetail.ALL;

public final class RequestSpecFactory {
    private static final TestConfig CFG = ConfigFactory.create(TestConfig.class, System.getProperties());

    private RequestSpecFactory() {}

    public static RequestSpecification base() {
        return new RequestSpecBuilder()
                .setBaseUri(CFG.baseUrl())
                .setContentType(ContentType.JSON)
                .addHeader("Accept", "application/json")
                .setRelaxedHTTPSValidation() // if needed for non-prod certs
                .setConfig(io.restassured.RestAssured.config()
                        .httpClient(io.restassured.config.HttpClientConfig.httpClientConfig()
                                .setParam("http.connection.timeout", CFG.connectTimeoutMs())
                                .setParam("http.socket.timeout", CFG.readTimeoutMs())
                        ))
                .log(ALL)
                .build();
    }

    public static RequestSpecification withAuth() {
        return base()
                .header("Authorization", "Bearer " + CFG.defaultUserToken());
    }
}
