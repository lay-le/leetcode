package com.layle.algo.string;

import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic if the characters in s can
 * be replaced to get t.
 *
 * For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
 * Created by layle on 2019-05-31.
 */
public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println("Are \"egg\" and \"add\" isomorphic: " + isIsomorphic("egg", "add"));
        System.out.println("Are \"foo\" and \"bar\" isomorphic: " + isIsomorphic("foo", "bar"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(map1.containsKey(c1)){
                if(c2!=map1.get(c1)){
                    return false;
                }
            }else{
                if(map2.containsKey(c2)){
                    return false;
                }

                map1.put(c1, c2);
                map2.put(c2, c1);
            }
        }

        return true;
    }
}
