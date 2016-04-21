package com.cosmos.leetcode.c001;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 *
 * @author BSD
 */
public class TwoSum {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *
     * You may assume that each input would have exactly one solution.
     *
     * @param nums input integer array
     * @param target sum
     * @return  indices of the two numbers such that they add up to a specific target
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            if(cache.containsKey(nums[i]) && i != cache.get(nums[i])) {
                return new int[]{i, cache.get(nums[i])};
            }
            cache.put(target - nums[i], i);
        }
        return null;
    }
}
