package com.company;

/**
 * Created by Kaszuba on 04.10.2017.
 */
public class Utils {
    /**
     * Function for checking if number is prime
     *
     * @param a - number to check if its prime
     * @return true/false if number is prime or not
     */
    public static boolean isPrime(int a) {
        for (int i = 2; i <= a / 2; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Function for finding Least common multiple
     *
     * @param a - first number
     * @param b - second number
     * @return Least common multiple
     */
    public static int leastCommonMultiple(int a, int b) {
        int max, min, lcm = 0;
        if (a > b) {
            min = b - 1;
            max = a - 1;
        } else {
            min = a - 1;
            max = b - 1;
        }
        for (int i = 1; i <= max; i++) {
            if ((min * i) % max == 0) {
                lcm = min * i;
                break;
            }
        }
        return lcm;
    }
}
