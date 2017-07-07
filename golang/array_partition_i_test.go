package main

import (
	"testing"
)

func TestArrayPairSum(t *testing.T) {
	nums := []int{1, 4, 3, 2}
	if 4 != arrayPairSum(nums) {
		t.Error("array pair sum failed")
	}
}
