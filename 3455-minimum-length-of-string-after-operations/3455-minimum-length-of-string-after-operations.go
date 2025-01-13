func minimumLength(s string) int {
	m := make(map[rune]int)

	for _, r := range s {
		m[r]++
	}

	count := 0
	for k, v := range m {
		if v > 2 {
			if v%2 == 0 {
				m[k] = 2
			} else {
				m[k] = 1
			}
		}

		count += m[k]
	}

	return count
}