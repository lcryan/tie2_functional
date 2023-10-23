package com.example.tie2.utils;

import java.util.Random;

public class RandomStringGenerator {

    public static String generateAlphaNumeric(int randomNumber) {
        int leftLimit = 48; // number '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(randomNumber)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}