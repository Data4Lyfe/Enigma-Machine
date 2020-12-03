package com.company;

public class English {
    // Instance Variables
    private static int totalNumberOfLetters;
    final private static int max = Rotor.max;
    private static double [] engLetterFreq = {8.1,1.6,3.2,3.6,12.3,2.3,1.6,5.1,7.2,0.1,0.5,4.0,
            2.2,7.2,7.9,2.3,0.2,6.0,6.6,9.6,3.1,0.9,2.0,0.2,1.9,0.1};
    private static double [] engLetterDev = {.1,.5,.3,.3,.1,.3,.5,.2,.15,1,.8,.3,.3,.2,.2,.3,1,
            .3,.2,.15,.3,.6,.4,1,.4,1};
    private static int[] letterCount = new int [max];
    private static double[] foundFreq = new double[max];

    // Instance Methods

    // Count the total number of letters and the frequency of each
    public static void countAllLetters(String s){
        //Reset values
        for(int i = 0; i<max; i++){
            letterCount[i] = 0;
            totalNumberOfLetters = 0;
        }

        //Calculate Numbers
        for(int i = 0; i<s.length();i++){
            if (s.charAt(i)<=90 && s.charAt(i)>=65) {
                letterCount[(s.charAt(i)+'A') % max] += 1;
                totalNumberOfLetters += 1;
            }
        }
    }


    // Calculate whether or not each letter is within a given frequency
    public static int getErrorCount(double mult){
        for (int i = 0; i<max; i++) {
            foundFreq[i] = (((double) (letterCount[i])) / totalNumberOfLetters) * 100;
        }

        int errorNum = max;
        for (int i=0; i<max;i++){
            if (engLetterFreq[i]-(mult*engLetterDev[i]*engLetterFreq[i])<foundFreq[i]
                    && foundFreq[i]<engLetterFreq[i]+(mult*engLetterDev[i]*engLetterFreq[i]))
                errorNum--;
        }
        return errorNum;
    }
}