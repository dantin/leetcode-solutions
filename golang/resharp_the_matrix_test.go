package main

import "testing"

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

func TestMatrixReshape(t *testing.T) {
	nums := makeMatrix(2, 2)

	if len(matrixReshape(nums, 1, 4)) != 1 {
		t.Error("resharp the matrix failed")
	}

}
