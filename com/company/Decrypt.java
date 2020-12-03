package com.company;

import java.io.*;

public class Decrypt {
    public static void Decrypt(EnigmaMachine em1) throws FileNotFoundException {
    // Pass the path to the file as a parameter

        // Given the rotor values we found for the file encryption, decrypt the file
        em1.setRotors(19,17,11);
        BufferedReader reader = null;

        try {
            File file = new File("C:\\Users\\75CS742740\\Documents\\HW1\\src\\com\\company\\encrypted file.txt");
            reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null)
                System.out.println(em1.encodeLine(line));


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
