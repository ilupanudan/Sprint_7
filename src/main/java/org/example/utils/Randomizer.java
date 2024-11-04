package org.example.utils;

import java.util.Random;

//Не мое, взял на https://for-each.dev/lessons/b/-java-random-string
public class Randomizer {
    public static String randomString() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 8;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;



    }

    public static String getRandomPhone() {
        String s = "123456789";
        StringBuffer bufer = new StringBuffer();

        for (int i = 0; i < 10; i++) {
            bufer.append(s.charAt(new Random().nextInt(s.length())));
        }
        return ("+7"+bufer.toString());
    }
}

