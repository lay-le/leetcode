package com.layle.algo.string;

/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 *
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * Created by layle on 2019-05-31.
 */
public class ReverseWordsInString {

    public static void main(String[] args) {
        String s = "the sky is blue";
        char[] chars = s.toCharArray();
        reverseWords(chars);
        System.out.println(new String(chars));
    }

    public static void reverseWords(char[] s) {
        int i=0;
        for(int j=0; j<s.length; j++){
            if(s[j]==' '){
                reverse(s, i, j-1);
                i=j+1;
            }
        }

        reverse(s, i, s.length-1);

        reverse(s, 0, s.length-1);
    }

    public static void reverse(char[] s, int i, int j){
        while(i<j){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }
}
