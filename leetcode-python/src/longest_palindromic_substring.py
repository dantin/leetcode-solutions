# -*- coding: utf-8 -*-
"""Given a string S, find the longest palindromic substring in S.
You may assume that the maximum length of S is 1000, and there
exists one unique longest palindromic substring.
"""


class Solution(object):
    @classmethod
    def longest_palindrome(cls, s):
        """
        :type s: str
        :rtype: str
        """
        for i, char in enumerate(s):
            pass
        return 'a'


if __name__ == '__main__':
    input_str = 'abcabcbb'
    palindrome = Solution.longest_palindrome(input_str)
    print(palindrome)
