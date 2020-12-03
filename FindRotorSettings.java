package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindRotorSettings {
    //===================================================================
    //Tunable Constants - EDIT THESE ONLY UNTIL THERE ARE ONE OR TWO DECRYPTS
    // (The values given here are example only - not the "real" ones I used
    final static int errorsAllowed = 5;
    final static double multiplier = 2;
    final static int numberOfLines = 4; // Number of lines of text to decode
    //====================================================================
    public static void FindRotorSettings(EnigmaMachine em1) throws FileNotFoundException {
        // pass the path to the file as a parameter
        File file = new File("C:\\Users\\75CS742740\\Documents\\HW1\\src\\com\\company\\encrypted file.txt");
        Scanner sc = new Scanner(file);
        String encryptedFile = "";


        // Read in a given number of lines of the encrypted file
        for (int i = 0; i<=numberOfLines; i++)
            encryptedFile += sc.nextLine();

        String encodedS;

        // Check all rotor settings for english frequency and output the matching result
        for (int i = 0; i<Rotor.max; i++)
            for (int j = 0; j<Rotor.max; j++)
                for (int k = 0; k<Rotor.max; k++){
                    em1.setRotors(i,j,k);
                    encodedS = em1.encodeLine(encryptedFile);
                    English.countAllLetters(encodedS);
                    if(English.getErrorCount(multiplier)<=errorsAllowed) {
                        System.out.println(i + " " + j + " " + k + " " + encodedS);
                    }
                }
    }
}