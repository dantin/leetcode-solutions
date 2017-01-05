package main

import "fmt"

func hammingDistance(x int, y int) int {
	var d int
	xor := x ^ y
	for xor != 0 {
		d += xor & 1
		xor /= 2
	}
	return d
}

func main() {
	var x, y = 1, 4

	fmt.Printf("Input: x = %d, y = %d\n", x, y)
	fmt.Printf("Output: %d\n", hammingDistance(x, y))
}
