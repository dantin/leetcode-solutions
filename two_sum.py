# -*- coding: utf-8 -*-
""" Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be
less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
"""


class Solution(object):

    @classmethod
    def two_sum(cls, _nums, _target):
        """
        :type _nums: List[int]
        :type _target: int
        :rtype: List[int]
        """
        # 这里的重点是构造一个缓存:
        #    [差]=下标
        # 后面的判断可以利用这个缓存
        cache = dict()
        for i, num in enumerate(_nums):
            if (num in cache.keys()) and (i != cache[num]):
                return cache[num] + 1, i + 1
            cache[_target - num] = i
        return None


if __name__ == '__main__':
    nums = [0, 4, 3, 0]
    target = 0
    r = Solution.two_sum(nums, target)
    if r:
        print('index1=%d, index2=%d' % r)
    else:
        print('Not found!')
