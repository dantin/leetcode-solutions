package main

import (
	"strconv"
)

func fizzBuzz(n int) []string {
	r := make([]string, 0)

	for i := 1; i <= n; i++ {
		var s string
		if i%3 == 0 {
			s = "Fizz"
		}
		if i%5 == 0 {
			s += "Buzz"
		}
		if len(s) == 0 {
			s = strconv.Itoa(i)
		}

		r = append(r, s)
	}

	return r
}
