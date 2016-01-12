# -*- coding: utf-8 -*-
""" You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and
each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
"""


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    @classmethod
    def add_two_numbers(cls, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        __result = None
        tail = None
        s = 0
        while l1 and l2:
            s = l1.val + l2.val + s
            node = ListNode(s % 10)
            if not tail:
                __result = node
            else:
                tail.next = node
            tail = node
            s //= 10
            l1 = l1.next
            l2 = l2.next

        while l1:
            s = l1.val + s
            node = ListNode(s % 10)
            tail.next = node
            tail = node
            s //= 10
            l1 = l1.next

        while l2:
            s = l2.val + s
            node = ListNode(s % 10)
            tail.next = node
            tail = node
            s //= 10
            l2 = l2.next

        while s > 0:
            node = ListNode(s % 10)
            tail.next = node
            tail = node
            s //= 10

        return __result


if __name__ == '__main__':
    num1 = ListNode(2)
    num1.next = ListNode(4)
    num1.next.next = ListNode(3)

    num2 = ListNode(5)
    num2.next = ListNode(6)
    num2.next.next = ListNode(4)

    result = Solution.add_two_numbers(num1, num2)
    while result:
        print(result.val)
        result = result.next
