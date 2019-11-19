package com.layle.algo.string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * Created by layle on 2019-07-10.
 */
public class LongestCommonPrefix {

    /**
     * To solve this problem, we need to find the two loop conditions. One is the length of the shortest string.
     * The other is iteration over every element of the string array.
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length ==0){
            return "";
        }

        if(strs.length == 1){
            return strs[0];
        }

        int i=0;
        while(true){
            boolean flag = true;
            for(int j=1; j<strs.length; j++){
                if(strs[j].length()<=i || strs[j-1].length() <=i
                        || strs[j].charAt(i) != strs[j-1].charAt(i)){
                    flag = false;
                    break;
                }
            }

            if(flag){
                i++;
            }else{
                break;
            }
        }

        return strs[0].substring(0, i);
    }
}
