package main

import (
	"reflect"
	"testing"
)

func TestFizzBuzz(t *testing.T) {
	s := []string{"1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"}
	if !reflect.DeepEqual(s, fizzBuzz(15)) {
		t.Error("FizzBuzz failed")
	}
}
