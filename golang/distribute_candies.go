package main

import "fmt"

func distributeCandies(candies []int) int {
	set := make(map[int]bool)
	for _, v := range candies {
		set[v] = true
	}

	if len(set) >= len(candies)/2 {
		return len(candies) / 2
	} else {
		return len(set)
	}
}

func main() {
	candies := []int{1, 1, 2, 3}

	fmt.Println(candies)
	fmt.Println(distributeCandies(candies))
}
