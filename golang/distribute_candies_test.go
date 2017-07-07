package main

import (
	"testing"
)

func TestDistributeCandies(t *testing.T) {
	candies := []int{1, 1, 2, 3}

	if 2 != distributeCandies(candies) {
		t.Error("Distribute Candies failed")
	}
}
