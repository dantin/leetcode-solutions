package main

import "testing"

func TestReverseString(t *testing.T) {
	s := "hello"

	if "olleh" != reverseString(s) {
		t.Error("reverse string failed")
	}
}
