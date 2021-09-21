package com.spotify.oauth2.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.spotify.oauth2.api.Route.BASE_PATH;

//this class will provide the standard url needed for API testing
public class SpecBuilder {
//https://api.spotify.com/v1/users/bsac66d2kcixjeae52m98vs78/playlists
    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder().
                setBaseUri("https://api.spotify.com").
                setBasePath(BASE_PATH).//v1
                setContentType(ContentType.JSON).
                addFilter(new AllureRestAssured()).
                log(LogDetail.ALL).
                build();
    }
//this class is responsible for renewing the token
    public static RequestSpecification getAccountRequestSpec(){
        return new RequestSpecBuilder().setBaseUri("https://accounts.spotify.com").
                setContentType(ContentType.URLENC).//since its application/x-www-form-urlencoded ,check in postman
                addFilter(new AllureRestAssured()).
                log(LogDetail.ALL).
                build();
    }

    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder().
                log(LogDetail.ALL).
                build();
    }
}
