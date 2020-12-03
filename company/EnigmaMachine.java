package com.company;

public class EnigmaMachine {
    private Rotor r1;        // First Rotor
    private Rotor r2;        // Second Rotor
    private Rotor r3;        // Third Rotor
    private Reflector r;     // Reflector

    //Constructor
    public EnigmaMachine(Rotor r1U, Rotor r2U, Rotor r3U, Reflector rU){
         r1 = r1U;
         r2 = r2U;
         r3 = r3U;
         r = rU;
    }

    // Encode one character
    private char encodeChar(char ch) {
        char encodedCharacter = ch;
        if (ch>=65 && ch<=90) {
            encodedCharacter = r1.encodeRL(r2.encodeRL(r3.encodeRL(r.encode(r3.encodeLR(r2.encodeLR(r1.encodeLR(ch)))))));
            incrementRotors();
        }
        return encodedCharacter;
    }

    //Encode one line of characters
    public String encodeLine(String s) {
        String str = "";
        for (int i = 0; i <s.length(); i++) {
            str = str + encodeChar(s.charAt(i));
        }
        return str;
    }

    // Provide values for the initial rotor positions
    public void setRotors(int a, int b, int c) {
        r1.set(a);
        r2.set(b);
        r3.set(c);
    }

    // Increment the rotors
    public void incrementRotors() {
        if (r1.inc())
            if (r2.inc())
                r3.inc();

    }
}