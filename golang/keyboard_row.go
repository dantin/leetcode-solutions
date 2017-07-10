package main

import (
	"unicode"
)

func findWords(words []string) []string {
	keybord := [][]rune{
		[]rune{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
		[]rune{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
		[]rune{'z', 'x', 'c', 'v', 'b', 'n', 'm'},
	}
	char_map := make(map[rune]int)
	for row, chars := range keybord {
		for _, c := range chars {
			char_map[c] = row
			char_map[unicode.ToUpper(c)] = row
		}
	}

	res := make([]string, 0)
	for _, word := range words {
		cs := []rune(word)
		row := char_map[cs[0]]
		f := true
		for _, c := range cs {
			if char_map[c] != row {
				f = false
				break
			}
		}
		if f {
			res = append(res, word)
		}
	}

	return res
}
