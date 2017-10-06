package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    /**
     * @param value - number to the power
     * @param power - power
     * @param mod   - modulo
     * @return - result
     */
    public static int modularExponentiation(int value, int power, int mod) {
        int e = 1;
        for (int i = 0; i < power; i++) {
            e = ((e * value) % mod);

        }
        return e;
    }

    /**
     * Function for generating random prime numbers from range
     *
     * @param numberOfPrimeNumbers - how many prime numbers to find
     * @param min - minimum range
     * @param max - maximum range
     * @return - prime numbers generated
     */
    public static List<Integer> randomPrimeNumbers(int numberOfPrimeNumbers, int min, int max) {
        List<Integer> primeNumbers = new ArrayList<Integer>();
        int primeNumber;
        Random generator = new Random();
        do {
            primeNumber = generator.nextInt((max - min) + 1) + min;
            if (Utils.isPrime(primeNumber)) {
                primeNumbers.add(primeNumber);
            }
        } while (primeNumbers.size() != numberOfPrimeNumbers);
        return primeNumbers;
    }

    /**
     * Function for finding Greatest Common Multiple
     *
     * @param a - first number
     * @param b - second number
     * @return Greatest Common Multiple of a and b
     */
    public static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    /**
     * Function for calculating Modular Inverse
     *
     * @param a - number
     * @param m - modulo
     * @return - Modular Inverse
     */
    public static int modInverse(int a, int m) {
        int m0 = m, t, q;
        int x0 = 0, x1 = 1;
        if (m == 1)
            return 0;

        while (a > 1) {
            // q is quotient
            q = a / m;

            t = m;

            // m is remainder now
            // Euclid's algorithm
            m = a % m;
            a = t;

            t = x0;

            x0 = x1 - q * x0;

            x1 = t;
        }
        // Make x1 positive
        if (x1 < 0)
            x1 += m0;

        return x1;
    }
}
