package com.cosmos.leetcode.c009;

/**
 * Palindrome Number
 *
 * @author BSD
 */
public class PalindromeNumber {

    /**
     * Determine whether an integer is a palindrome.
     *
     * @param x integer
     * @return true if x is a palindrome, false otherwise
     */
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        int value = x;
        int palindrome = 0;

        while(value != 0) {
            palindrome *= 10;
            palindrome += value % 10;
            value /= 10;
        }

        return palindrome == x;
    }
}
