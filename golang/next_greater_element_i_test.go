package main

import (
	"reflect"
	"testing"
)

func TestNextGreaterElement(t *testing.T) {
	findNums := []int{4, 1, 2}
	nums := []int{1, 3, 4, 2}

	if !reflect.DeepEqual([]int{-1, 3, -1}, nextGreaterElement(findNums, nums)) {
		t.Error("next greater element i failed")
	}
}
