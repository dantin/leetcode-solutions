package main

import (
	"fmt"
	"sort"
)

func arrayPairSum(nums []int) int {
	sort.Ints(nums)
	sum := 0
	for i, v := range nums {
		if i%2 == 0 {
			sum += v
		}
	}

	return sum
}

func main() {
	nums := []int{1, 4, 3, 2}
	fmt.Println(arrayPairSum(nums))
}
