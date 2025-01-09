func isVowel(char string) bool {
	if char == "a" || char == "e" || char == "i" || char == "o" || char == "u" {
		return true
	}

	return false
}

func vowelStrings(words []string, queries [][]int) []int {
	count := make([]int, len(words))
	result := make([]int, len(queries))

	for i, word := range words {
		if isVowel(string(word[0])) && isVowel(string(word[len(word)-1])) {
			count[i] = 1
		}
	}

	for i := 1; i < len(count); i++ {
		count[i] = count[i] + count[i-1]
	}

  

	for i, query := range queries {
		l := query[0]
		r := query[1]

		if l == 0 {
			result[i] = count[r]
		} else {
			result[i] = count[r] - count[l-1]
		}

	}

	return result
}