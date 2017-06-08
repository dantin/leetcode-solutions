package main

import "fmt"

func reverseString(s string) string {
	buf := []rune(s)

	for i, j := 0, len(buf)-1; i < j; i, j = i+1, j-1 {
		buf[i], buf[j] = buf[j], buf[i]
	}

	return string(buf)
}

func main() {
	s := "hello"

	fmt.Println(s)
	fmt.Println(reverseString(s))
}
