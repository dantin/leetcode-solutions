package main

func islandPerimeter(grid [][]int) int {
	sum := 0

	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			if grid[i][j] == 1 {
				sum += 4
				if i > 0 && grid[i-1][j] == 1 {
					sum -= 2
				}
				if j > 0 && grid[i][j-1] == 1 {
					sum -= 2
				}
			}
		}
	}

	return sum
}
