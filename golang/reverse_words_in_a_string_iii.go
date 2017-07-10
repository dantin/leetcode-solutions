package main

func reverseWords(s string) string {
	buf := []rune(s)

	for i := 0; i < len(buf); i++ {
		if buf[i] != ' ' {
			j := i
			for j < len(buf) && buf[j] != ' ' {
				j++
			}
			reverse(buf, i, j-1)
			i = j
		}
	}

	return string(buf)
}

func reverse(s []rune, i int, j int) {
	for ; i < j; i, j = i+1, j-1 {
		s[i], s[j] = s[j], s[i]
	}
}
