package main

import (
	"reflect"
	"testing"
)

func TestFindWord(t *testing.T) {
	words := []string{"Hello", "Alaska", "Dad", "Peace"}

	if !reflect.DeepEqual([]string{"Alaska", "Dad"}, findWords(words)) {
		t.Error("keyboard row test failed")
	}
}
