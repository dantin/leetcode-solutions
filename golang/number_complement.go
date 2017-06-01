package main

import "fmt"

func findComplement(num int) int {
    mask := ^0
    for (mask & num) > 0 {
        mask <<= 1
    }
    return ^mask & ^num
}

// func findComplement1(num int) int {
//     upper := 1
//     for upper <= num {
//         upper <<= 1
//     }
//     return upper - num - 1
// }

func main() {
    var n int

    fmt.Scan(&n)

    fmt.Println(findComplement(n))
}