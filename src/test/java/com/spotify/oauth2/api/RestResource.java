package com.spotify.oauth2.api;

import io.restassured.response.Response;

import java.util.HashMap;

import static com.spotify.oauth2.api.Route.API;
import static com.spotify.oauth2.api.Route.TOKEN;
import static com.spotify.oauth2.api.SpecBuilder.*;
import static io.restassured.RestAssured.given;

public class RestResource {

    public static Response post(String path, String token, Object requestPlaylist)
    {//since Request play list contains the body,so it can be of any Testcase,Like for eg Post or put or Create Play List TC,so using object
        return given(getRequestSpec()).//passing https://api.spotify.com/v1
                body(requestPlaylist).//passing the body values
                auth().oauth2(token).//passing token
        when().post(path).//passing the remaining pat of url /users/bsac66d2kcixjeae52m98vs78
        then().spec(getResponseSpec()).
                extract().
                response();
    }
//returning response to main Test class
    public static Response postAccount(HashMap<String, String> formParams){
        return given(getAccountRequestSpec()).//so here we are getting the url https://accounts.spotify.com"
                formParams(formParams).//the Body parameters
        when().post(API + TOKEN). //--/api/token
        then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response get(String path, String token){
        return given(getRequestSpec()).//passing https://api.spotify.com/v1
                auth().oauth2(token).
        when().get(path).
        then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response update(String path, String token, Object requestPlaylist){
        return given(getRequestSpec()).
                auth().oauth2(token).
                body(requestPlaylist).
        when().put(path).
        then().spec(getResponseSpec()).
                extract().
                response();
    }
}
