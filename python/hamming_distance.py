# -*- coding: utf-8 -*-

class Solution(object):

    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        return bin(x^y).count('1')

    def hammingDistance1(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        d = 0
        xor = x ^ y
        while xor != 0:
            d += xor & 1;
            xor /= 2;

        return d


if __name__ == '__main__':
    x, y = 1, 4
    print "x = %d, y = %d" % (x, y)

    solution = Solution()
    print solution.hammingDistance(x, y)
