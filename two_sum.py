# -*- coding: utf-8 -*-
"""
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be
less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
"""


class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        cache = dict()
        for i in range(0, len(nums)):
            if (nums[i] in cache.keys()) and (i != cache[nums[i]]):
                return cache[nums[i]] + 1, i + 1
            cache[target - nums[i]] = i
        return None


if __name__ == '__main__':
    nums = [0, 4, 3, 0]
    target = 0
    s = Solution()
    r = s.twoSum(nums, target)
    if r:
        print 'index1=%d, index2=%d' % r
    else:
        print 'Not found!'
