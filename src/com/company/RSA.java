package com.company;

import java.util.List;
import java.util.Random;

/**
 * Created by Kaszuba on 06.10.2017.
 */
public class RSA {

    private int p;
    private int q;
    private int n;
    private int lambda;
    private int e; // Encryption key
    private int d; // Decryption key

    /**
     * Constructor for RSA
     *
     * @param min - minimum range for finding prime numbers
     * @param max - maximum range for finding prime numbers
     */
    public RSA(int min, int max) {
        List<Integer> primeNumbers = Utils.randomPrimeNumbers(2, min, max);
        this.p = primeNumbers.get(0);
        this.q = primeNumbers.get(1);
        this.n = this.p * this.q;
        //this.lambda = Utils.leastCommonMultiple(this.p, this.q);
        this.lambda = (this.p - 1) * (this.q - 1);
    }

    /**
     * Function for generating encryption key
     * <p>
     * Generating encryption key(e) requirements:
     * e must be a prime number
     * 1 < e < lambda(n) ( WIKIPEDIA )
     * <p>
     * Optional: ( ONE CHINESE GUY ON YOUTUBE TOLD 2 MORE )
     * e cannot be a divider of lambda
     * e cannot be a divider of n
     */
    public void generateEncryptionKey() {
        int min = 1;
        int max = this.lambda;
        double firstDivider;
        //double secondDivider;
        boolean found = false;
        Random generator = new Random();

        do {
            this.e = generator.nextInt((max - min) + 1) + min;
            if (Utils.isPrime(this.e)) {
                firstDivider = (double) lambda / (double) e;
                //secondDivider = (double) n / (double) e;
                if ((firstDivider != (int) firstDivider)) {// && (secondDivider != (int) secondDivider)) {
                    found = true;
                }
            }
        } while (!found);
    }

    /**
     * Function for generating decryption key (using modular inverse function)
     */
    public void generateDecryptionKey() {
        /*int x = 0;
        int y = lambda;
        do {
            x = x + this.e;
        } while (x % y != 1);
        this.d = x / e;*/
        this.d = Utils.modInverse(e, lambda);
    }

    /**
     * Function for encrypting message
     *
     * @param message - message to be encrypted
     * @return - encrypted message
     */
    public int encryptMessage(int message) {
        int encryptedMessage = Utils.modularExponentiation(message, this.e, this.n);
        return encryptedMessage;
    }

    /**
     * Function for decrypting message
     *
     * @param message - message to be decrypted
     * @return - decrypted message
     */
    public int decryptMessage(int message) {
        int decryptedMessage = Utils.modularExponentiation(message, this.d, this.n);
        return decryptedMessage;
    }

    /**
     * GETTERS AND SETTERS OF ALL PARAMS (FOR DEBUGGING PURPOSE)
     */

    public void setP(int p) {
        this.p = p;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public void setE(int e) {
        this.e = e;
    }

    public void setD(int d) {
        this.d = d;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setLambda(int lambda) {
        this.lambda = lambda;
    }

    public int getE() {
        return e;
    }

    public int getD() {
        return d;
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }

    public int getLambda() {
        return lambda;
    }
}
