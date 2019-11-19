package com.layle.algo.string;

import java.util.ArrayList;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Created by layle on 2019-05-31.
 */
public class ReverseVowelsOfString {
    public static void main(String[] args) {
        String s = "the sky is blue";
        char[] chars = s.toCharArray();
        System.out.println(s);
        s = reverseVowels(s);
        System.out.println(s);
    }

    public static String reverseVowels(String s) {
        ArrayList<Character> vowList = new ArrayList<Character>();
        vowList.add('a');
        vowList.add('e');
        vowList.add('i');
        vowList.add('o');
        vowList.add('u');
        vowList.add('A');
        vowList.add('E');
        vowList.add('I');
        vowList.add('O');
        vowList.add('U');

        char[] arr = s.toCharArray();

        int i=0;
        int j=s.length()-1;

        while(i<j){
            if(!vowList.contains(arr[i])){
                i++;
                continue;
            }

            if(!vowList.contains(arr[j])){
                j--;
                continue;
            }

            char t = arr[i];
            arr[i]=arr[j];
            arr[j]=t;

            i++;
            j--;
        }

        return new String(arr);
    }
}
