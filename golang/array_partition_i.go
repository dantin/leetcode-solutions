package main

import (
	"fmt"
	"sort"
)

func arrayPairSum(nums []int) int {
	sort.Ints(nums)
	sum := 0
	for i := 0; i < len(nums); i++ {
		if i%2 == 0 {
			sum += nums[i]
		}
	}

	return sum
}

func main() {
	nums := []int{1, 4, 3, 2}
	fmt.Println(arrayPairSum(nums))
}
