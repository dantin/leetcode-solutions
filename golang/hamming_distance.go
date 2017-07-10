package main

func hammingDistance(x int, y int) int {
	d := 0
	xor := x ^ y
	for xor != 0 {
		d += xor & 1
		xor /= 2
	}
	return d
}
