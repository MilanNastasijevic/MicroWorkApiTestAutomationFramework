package com.microworkers.smoke;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BooksListResponseTest {
    @Test
    public void GetBookDetails(){
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.get("");

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode,200,"right status code returned");
    }

    @Test
    public void GetPetDetails()
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://demoqa.com/Account/v1/User/";
        // Get the RequestSpecification of the request to be sent to the server
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.get("test");

        // Get the status code of the request.
        //If request is successful, status code will be 200
        int statusCode = response.getStatusCode();

        // Assert that correct status code is returned.
        Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/,
                "Correct status code returned");
    }

}
