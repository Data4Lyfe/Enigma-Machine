package com.company;

import java.io.FileNotFoundException;

public class EnigmaMachineUser {

    public static void main(String[] args) throws FileNotFoundException {
        Rotor r1 = new Rotor("QWERTYUIOPLKJHGFDSAZXCVBNM");
        Rotor r2 = new Rotor("ZAQWSXCDERFVBGTYHNMJUIKLOP");
        Rotor r3 = new Rotor("PLOKMIJNUHBYGVTFCRDXESZWAQ");
        Reflector rf = new Reflector("NPKMSLZTWQCFDAVBJYEHXOIURG");

        EnigmaMachine em = new EnigmaMachine(r1,r2,r3,rf);

        // Print initial string
        String s = "AAAAAAAAAAAAAAAAAAAAAAAAAAA";
        System.out.println(s);

        em.setRotors(5,9,14);

        // Print encoded string
        String encodedS = em.encodeLine(s);
        System.out.println(encodedS);

        // Print the encoded encoded string
        // It should be the original (check statement)
        em.setRotors(5,9,14);
        String decodedEncodedS = em.encodeLine(encodedS);
        System.out.println(decodedEncodedS);
        System.out.println("\n============================================================\n");

        // Use method to find and output Rotor settings
        FindRotorSettings.FindRotorSettings(em);

        System.out.println("\n=============================================================\n");

        // Use method to decrypt the file and output the decrypted messaged\
        Decrypt.Decrypt(em);
    }
}