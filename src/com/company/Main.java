package com.company;

public class Main {

    public static void main(String[] args) {

        /**
         * Minimum and maximum range for finding prime numbers
         */
        int minRange = 100;
        int maxRange = 200;
        /**
         * Message to be encrypted
         */
        int message = 624;


        RSA rsa = new RSA(minRange, maxRange);

        rsa.generateEncryptionKey();
        rsa.generateDecryptionKey();

        int encryptedMessage = rsa.encryptMessage(message);
        int decryptedMessage = rsa.decryptMessage(encryptedMessage);

        System.out.println("Encryption key = " + rsa.getE() + "\nDecryption key = " + rsa.getD() +
                "\nMessage to be encrypted = " + message + " EncryptedMessage = " + encryptedMessage +
                "\nDecryptedMessage = " + decryptedMessage);

        if(decryptedMessage == message) System.out.println("SUCCESS!");
        else System.out.println("FAIL!");


    }
}
