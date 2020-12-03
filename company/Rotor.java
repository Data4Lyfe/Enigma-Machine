package com.company;

public class Rotor {
    // Instance variables
    private int position;                               // rotor position
    final static int max = 26;                          // # of letters in alphabet
    private char[] leftToRightWiring = new char[max];   // L->R wiring - from constructor parameter
    private char[] rightToLeftWiring = new char[max];   // R->L wiring - GENERATED FROM L->R WIRING

    // Instance Methods
    public Rotor(String s) { // Constructor

        position = 0;
        for (int i=0; i< max ; i++) {
            leftToRightWiring[i] = s.charAt(i);
            rightToLeftWiring[s.charAt(i) - 'A'] = (char)(i + 'A');
        }
    }

    public boolean inc() {      // Advance the position by one
       position++;              // "click, 0.. 25, and return
       if (position == max) {   // whether the rotor went from
           position = 0;        // 25 back to 0
           return true;
       }
        return false;
    }

    public void set(int n) {    // Set the rotor position to n
        position = n;
    }

    public char encodeLR(char c) {  //Return the character c is wired to going L->R
        int ArrayIndex = ((c - 'A' + position)%max);
        return leftToRightWiring[ArrayIndex];
    }

    public char encodeRL(char c) {  //Return the character c is wired to going R->L

        int asciiNum = rightToLeftWiring[(c - 'A') % max] - position;

        if (asciiNum < 'A')
            asciiNum = asciiNum+max;

        return (char)asciiNum;
    }
}