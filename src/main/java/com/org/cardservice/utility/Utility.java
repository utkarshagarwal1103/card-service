package com.org.cardservice.utility;

public class Utility {

    public static boolean validateCreditCardNumber(String cc) {
        final boolean[] dbl = {false};
        return cc
                .replaceAll("\\s+", "")
                .chars()
                .map(c -> Character.digit((char) c, 10))
                .map(i -> ((dbl[0] = !dbl[0])) ? (((i*2)>9) ? (i*2)-9 : i*2) : i)
                .sum() % 10 == 0;
    }

}
