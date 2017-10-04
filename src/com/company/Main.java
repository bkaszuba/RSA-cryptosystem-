package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int firstPrime = 0, secondPrime = 0;
        boolean firstPrimeFound = false, secondPrimeFound = false;

        Random generator = new Random();

        /**
         *  @param firstPrimeFound - flag for checking if first prime number was found
         *  @param secondPrimeFound - flag for checking if first prime number was found
         */
        do {
            if (!firstPrimeFound) {
                //firstPrime = generator.nextInt(Integer.MAX_VALUE-1);
                firstPrime = generator.nextInt((15 - 1) + 1) + 1;
                firstPrimeFound = Utils.isPrime(firstPrime);
            }
            if (!secondPrimeFound) {
                //secondPrime = generator.nextInt(Integer.MAX_VALUE-1);
                secondPrime = generator.nextInt((15 - 1) + 1) + 1;
                secondPrimeFound = Utils.isPrime(secondPrime);
            }
        } while (!firstPrimeFound || !secondPrimeFound);

        //Accoring to Wikipedia we should call 2 prime number p and q
        int p = firstPrime;
        int q = secondPrime;

        //Compute n=p*q
        int n = p * q;

        //Compute lambda(n) = lcm(p-1, q-1)
        int lambda = Utils.leastCommonMultiple(p, q);

        //Find coprime number e 1<e<lambda(n)
        int min = 1;
        int max = lambda;
        int e;
        double firstDivisor;
        double secondDivisor;
        boolean found = false;

        do {
            e = generator.nextInt((max - min) + 1) + min;
            if (Utils.isPrime(e) == true) {
                firstDivisor = (double) lambda / (double) e;
                secondDivisor = (double) n / (double) e;
                if ((firstDivisor != (int) firstDivisor) && (secondDivisor != (int) secondDivisor)) {
                found = true;
                }
            }
        } while (!found);
        System.out.println("p = " + p + " q = " + q);
        System.out.println("n = " + n + " lcm = " + lambda);
        System.out.println("Encryption = " + e);
        int x = 0;
        int y = lambda;
        do {
            x = x + e;
        } while (x % y != 1);
        int d = x/e;
        System.out.println("Decription = " +d);
        //ENCRYPTION
        //d=413;
        //e=17;
        //n=3233;
        int message = 65;
        double cipherText = Math.pow(message, e);
        System.out.println(cipherText);
        double c = cipherText%n;
        System.out.println("Value = " + 12 + "Encrypted value = " + c);
        //DECRYPTION
        double dmessage = Math.pow(c, d);
        double m = dmessage%n;
        System.out.println("Decrypted value = " + m);




    }
}
