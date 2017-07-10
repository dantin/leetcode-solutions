package main

import "testing"

func TestFindWord(t *testing.T) {
	words := []string{"Hello", "Alaska", "Dad", "Peace"}

	if len(findWords(words)) != 2 {
		t.Error("keyboard row test failed")
	}
}
