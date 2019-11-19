package com.layle.algo.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * Created by layle on 2019-06-03.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};

        System.out.println("Two Sum indexes: " + Arrays.toString(twoSum(input, 9)));
        System.out.println("Two Sum indexes: " + Arrays.toString(twoSum(input, 18)));
        System.out.println("Two Sum indexes: " + Arrays.toString(twoSum(input, 4)));
    }
    /**
     * The function twoSum should return indices of the two numbers such that they add up to the target,
     * where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
     * are not zero-based.
     *
     * The optimal solution to solve this problem is using a HashMap. For each element of the array,
     * (target-nums[i]) and the index are stored in the HashMap.
     */
    public static int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length<2)
            return new int[]{0,0};

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }else{
                map.put(target-nums[i], i);
            }
        }

        return new int[]{0,0};
    }
}
