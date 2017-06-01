package main

import "fmt"

func matrixReshape(nums [][]int, r int, c int) [][]int {
    re := 0
    res := make([][]int, r)
    for i := 0; i < r; i++ {
        res[i] = make([]int, c)
        re += c
    }

    idx := 0
    for i := 0; i < len(nums); i++ {
        for j:= 0; j < len(nums[i]); j++ {
            if idx < re {
                res[idx/c][idx % c] = nums[i][j]
            } else {
                return nums
            }
            idx++
        }
    }

    if idx != re {
        return nums
    } else {
        return res
    }
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
    fmt.Println(matrixReshape(nums, 2, 4))
}