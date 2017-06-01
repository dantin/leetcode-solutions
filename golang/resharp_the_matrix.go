package main

import "fmt"

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

func makeMatrix(row int, column int) [][]int {
	matrix := make([][]int, row)

	num := 1
	for i := 0; i < row; i++ {
		matrix[i] = make([]int, column)
		for j := 0; j < column; j++ {
			matrix[i][j] = num
			num++
		}
	}

	return matrix
}

func main() {
	nums := makeMatrix(2, 2)
	fmt.Println(nums)
	fmt.Println(matrixReshape(nums, 1, 4))
}
