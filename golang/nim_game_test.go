package main

import "testing"

func TestCanWinNim(t *testing.T) {
	if canWinNim(4) {
		t.Error("nim game failed")
	}
}
