package com.layle.algo.string;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * For example, "Red rum, sir, is murder" is a palindrome, while "Programcreek is awesome" is not.
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Created by layle on 2019-05-31.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println("Is \"Red rum, sir, is murder\" palindrome: " + isPalindrome("Red rum, sir, is murder"));
        System.out.println("Is \"Programcreek is awesome\" palindrome: " + isPalindrome("Programcreek is awesome"));
    }
    /**
     * The following is a solution with O(n) time complexity and O(1) space complexity.
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if(s==null){
            return false;
        }

        s = s.toLowerCase();

        int i=0;
        int j=s.length()-1;

        while(i<j){
            while(i<j && !((s.charAt(i)>='a' && s.charAt(i)<='z')
                    || (s.charAt(i)>='0'&&s.charAt(i)<='9'))){
                i++;
            }

            while(i<j && !((s.charAt(j)>='a' && s.charAt(j)<='z')
                    || (s.charAt(j)>='0'&&s.charAt(j)<='9'))){
                j--;
            }

            if(s.charAt(i) != s.charAt(j)){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
