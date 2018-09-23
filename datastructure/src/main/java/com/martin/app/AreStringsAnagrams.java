package com.martin.app;

import java.util.Arrays;


public class AreStringsAnagrams {

    public boolean AreStringsAnagrams(String a, String b) {
        if (a.length() != b.length()) return false;

        int[] letters = new int[26];

        //initialization
        for (int i = 0; i < letters.length; i++) {
            letters[i] = 0;
        }

        //process the string a

        char[] arrayA = a.toLowerCase().toCharArray();
        char[] arrayB = b.toLowerCase().toCharArray();

        for (int i = 0; i < arrayA.length; i++) {
            ++letters[arrayA[i] - 96];
            --letters[arrayB[i] - 96];
        }

        return Arrays.stream(letters).allMatch(le -> le == 0);
    }

    public boolean AreStringsAnagrams2(String a, String b) {
        if (a.length() != b.length()) return false;

        char[] arrayA = a.toLowerCase().toCharArray();
        char[] arrayB = b.toLowerCase().toCharArray();

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);


        return Arrays.equals(arrayA, arrayB);
    }

    public static void main(String[] args) {
        AreStringsAnagrams test = new AreStringsAnagrams();

        boolean ret = test.AreStringsAnagrams("Mary", "Army");

        boolean ret2 = test.AreStringsAnagrams2("Mary", "Army");
        System.out.println(ret);
        System.out.println(ret2);

    }
}
