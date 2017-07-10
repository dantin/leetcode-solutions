package main

import "testing"

func TestFindComplement(t *testing.T) {
	num := 4
	if 3 != findComplement(num) {
		t.Error("find complement failed")
	}
}
