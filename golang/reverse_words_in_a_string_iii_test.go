package main

import "testing"

func TestReverseWords(t *testing.T) {
	input := "Let's take LeetCode contest"

	if "s'teL ekat edoCteeL tsetnoc" != reverseWords(input) {
		t.Error("reverse words in a string iii failed")
	}

}
