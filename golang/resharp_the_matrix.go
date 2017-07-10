package main

func matrixReshape(nums [][]int, r int, c int) [][]int {
	m, n := len(nums), len(nums[0])
	if m*n != r*c {
		return nums
	}

	reshape := make([][]int, r)
	for i := 0; i < r; i++ {
		reshape[i] = make([]int, c)
		for j := 0; j < c; j++ {
			k := i*c + j
			reshape[i][j] = nums[k/n][k%n]
		}
	}

	return reshape
}
