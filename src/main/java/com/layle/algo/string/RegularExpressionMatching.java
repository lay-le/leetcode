package com.layle.algo.string;

/**
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 * Created by layle on 2019-05-31.
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println("isMatchSolution2(\"aa\",\"a\"): " + isMatchSolution1("aa", "a"));
        System.out.println("isMatchSolution2(\"aa\",\"aa\"): " + isMatchSolution1("aa", "aa"));
        System.out.println("isMatchSolution2(\"aaa\",\"aa\"): " + isMatchSolution1("aaa", "aa"));
        System.out.println("isMatchSolution2(\"aa\",\"a*\"): " + isMatchSolution1("aa", "a*"));
        System.out.println("isMatchSolution2(\"aa\",\".*\"): " + isMatchSolution1("aa", ".*"));
        System.out.println("isMatchSolution2(\"ab\",\".*\"): " + isMatchSolution1("ab", ".*"));
        System.out.println("isMatchSolution2(\"aab\",\"c*a*b\"): " + isMatchSolution1("aab", "c*a*b"));
    }

    /**
     * First of all, this is one of the most difficulty problems. It is hard to think through all different cases.
     * The problem should be simplified to handle 2 basic cases:
     *
     * the second char of pattern is "*"
     * the second char of pattern is not "*"
     * For the 1st case, if the first char of pattern is not ".", the first char of pattern and string should be the
     * same. Then continue to match the remaining part.
     *
     * For the 2nd case, if the first char of pattern is "." or first char of pattern == the first i char of string,
     * continue to match the remaining part.
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatchSolution1(String s, String p) {

        if(p.length() == 0)
            return s.length() == 0;

        //p's length 1 is special case
        if(p.length() == 1 || p.charAt(1) != '*'){
            if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
                return false;
            return isMatchSolution1(s.substring(1), p.substring(1));

        }else{
            int len = s.length();

            int i = -1;
            while(i<len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
                if(isMatchSolution1(s.substring(i+1), p.substring(2)))
                    return true;
                i++;
            }
            return false;
        }
    }

    /**
     * Solution 2 (More Readable)
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatchSolution2(String s, String p) {
        // base case
        if (p.length() == 0) {
            return s.length() == 0;
        }

        // special case
        if (p.length() == 1) {

            // if the length of s is 0, return false
            if (s.length() < 1) {
                return false;
            }

            //if the first does not match, return false
            else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
                return false;
            }

            // otherwise, compare the rest of the string of s and p.
            else {
                return isMatchSolution2(s.substring(1), p.substring(1));
            }
        }

        // case 1: when the second char of p is not '*'
        if (p.charAt(1) != '*') {
            if (s.length() < 1) {
                return false;
            }
            if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
                return false;
            } else {
                return isMatchSolution2(s.substring(1), p.substring(1));
            }
        }

        // case 2: when the second char of p is '*', complex case.
        else {
            //case 2.1: a char & '*' can stand for 0 element
            if (isMatchSolution2(s, p.substring(2))) {
                return true;
            }

            //case 2.2: a char & '*' can stand for 1 or more preceding element,
            //so try every sub string
            int i = 0;
            while (i<s.length() && (s.charAt(i)==p.charAt(0) || p.charAt(0)=='.')){
                if (isMatchSolution2(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }

}
