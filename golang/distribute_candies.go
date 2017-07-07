package main

func distributeCandies(candies []int) int {
	set := make(map[int]bool)
	for _, v := range candies {
		set[v] = true
	}

	if len(set) < len(candies)/2 {
		return len(set)
	}
	return len(candies) / 2
}
