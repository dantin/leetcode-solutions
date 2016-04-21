# -*- coding: utf-8 -*-
""" There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).
"""


class Solution(object):
    @classmethod
    def median_of_two_sorted_arrays(cls, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        # 插入排序
        merged_array = nums1[:]
        for i in range(len(nums1) + len(nums2)):
            if i < len(merged_array):
                if len(nums2) == 0:
                    break
                elif merged_array[i] < nums2[0]:
                    continue
                else:
                    num = nums2.pop(0)
                    merged_array.insert(i, num)
            else:
                break
        merged_array.extend(nums2)
        # 计算中位数位置
        mid = len(merged_array) // 2
        if len(merged_array) % 2 == 0:
            return (merged_array[mid] + merged_array[mid - 1]) / 2.0
        else:
            return merged_array[mid]


if __name__ == '__main__':
    a1 = [1, 2, 3]
    a2 = [4, 5]
    median = Solution.median_of_two_sorted_arrays(a1, a2)
    print(median)
