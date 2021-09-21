package com.spotify.oauth2.api.applicationApi;

import com.spotify.oauth2.api.RestResource;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.ConfigLoader;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static com.spotify.oauth2.api.Route.PLAYLISTS;
import static com.spotify.oauth2.api.Route.USERS;
import static com.spotify.oauth2.api.TokenManager.getToken;

public class PlaylistApi {

    @Step
    public static Response post(Playlist requestPlaylist){
        //passing the values to RestResource class method name post
        return RestResource.post(USERS + "/" + ConfigLoader.getInstance().getUser()//calling config class
                + PLAYLISTS, getToken(), requestPlaylist);
    }
    //so passing value /users/bsac66d2kcixjeae52m98vs78

    //so in above method we are calling Route class,Config class,Token manager class,
    //in short we are passing the URL and ALso the whole request Body

    //PlayList Api is calling rest Resource class and rest resource class is calling SpecBuilder class

    public static Response post(String token, Playlist requestPlaylist){
        return RestResource.post(USERS + "/" + ConfigLoader.getInstance().getUser()
                + PLAYLISTS, token, requestPlaylist);
    }

    public static Response get(String playlistId){

        return RestResource.get(PLAYLISTS + "/" + playlistId, getToken());
    }

    public static Response update(String playlistId, Playlist requestPlaylist){
        return RestResource.update(PLAYLISTS + "/" + playlistId, getToken(), requestPlaylist);
    }
}
