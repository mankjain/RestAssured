package com.spotify.oauth2.utils;

import com.github.javafaker.Faker;

public class FakerUtils {
//Here we are generating random name and random description which is used in main test

    public static String generateName(){//using generic name
        Faker faker = new Faker();
        return "Playlist " + faker.regexify("[A-Za-z0-9 ,_-]{10}");//returning String value.we can use other method also from faker
            //faker.animal();
    }

    public static String generateDescription(){
        Faker faker = new Faker();
        return "Description " + faker.regexify("[ A-Za-z0-9_@./#&+-]{50}");
    }
}
