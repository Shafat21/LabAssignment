package org.example;

import java.util.Random;

public class Calculator {
    public Integer add(Integer a, Integer b) {
        if (a == null || b == null) {
            return null;
        }
        return a + b;
    }

    public Integer divide(Integer a, Integer b) {
        if (a == null || b == null || b == 0) {
            return null;
        }
        return a / b;
    }

    public int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min; // Generates a number in the range [min, max]
    }
}
