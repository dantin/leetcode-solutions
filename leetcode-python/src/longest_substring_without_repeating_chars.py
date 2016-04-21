# -*- coding: utf-8 -*-
""" Given a string, find the length of the longest substring without repeating characters. For example, the longest
substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
is "b", with the length of 1.
"""


class Solution(object):
    @classmethod
    def length_of_longest_substring(cls, s):
        """
        :type s: str
        :rtype: int
        """
        # 基本思路是快慢指针和缓存
        # * 如果当前字符还未被缓存,向后移动快指针,同时缓存字符位置;
        # * 如果当前字符已经被缓存,向后移动慢指针,至冲突字符的下一位,移动慢指针同时清理缓存;
        slow = 0
        max_len = 0
        hash_table = [-1] * 256
        for fast, c in enumerate(s):
            if hash_table[ord(c)] != -1:
                while slow <= hash_table[ord(c)]:
                    hash_table[ord(s[slow])] = -1
                    slow += 1
            max_len = max(fast - slow + 1, max_len)
            hash_table[ord(c)] = fast
        return max_len


if __name__ == '__main__':
    input_str = 'abcabcbb'
    length = Solution.length_of_longest_substring(input_str)
    print(length)
