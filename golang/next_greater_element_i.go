package main

import (
	"github.com/dantin/leetcode-solutions/golang/stack"
)

func nextGreaterElement(findNums []int, nums []int) []int {
	cached := make(map[int]int)
	s := stack.New()
	for _, num := range nums {
		for !s.IsEmpty() && s.Peek().(int) < num {
			cached[s.Pop().(int)] = num
		}

		s.Push(num)
	}

	nexted := make([]int, 0)
	for _, num := range findNums {
		t, ok := cached[num]
		if ok {
			nexted = append(nexted, t)
		} else {
			nexted = append(nexted, -1)
		}
	}

	return nexted
}
