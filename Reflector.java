package com.company;

public class Reflector {
    final static int max = 26;
    private char[] wiring = new char[max];

    // L->R wiring - from constructor parameter
   public Reflector(String s){
       for (int i=0; i< max ; i++){
           wiring[i] = s.charAt(i);
       }
   }


    public char encode(char c) {  //Return the character c is wired to going
         int ArrayIndex = (c-'A');
        return wiring[ArrayIndex];
    }
}