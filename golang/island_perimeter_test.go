package main

import "testing"

func TestIslandPerimeter(t *testing.T) {
	grid := [][]int{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}

	if 16 != islandPerimeter(grid) {
		t.Error("island perimeter failed")
	}
}
