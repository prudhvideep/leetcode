func maxScore(s string) int {
	zeros := make([]int, len(s))
	ones := make([]int, len(s))
	maxCount := 0

	for i := 0; i < len(s); i++ {
		if s[i] == '0' {
			zeros[i] = 1
			ones[i] = 0
		} else {
			zeros[i] = 0
			ones[i] = 1
		}
		if i > 0 {
			zeros[i] += zeros[i-1]
			ones[i] += ones[i-1]
		}
	}

	for i := 0; i < len(s)-1; i++ {
		nZeros := zeros[i]
		nOnes := ones[len(s)-1] - ones[i]

		maxCount = max(maxCount, nZeros+nOnes)
	}

	return maxCount
}

func max(a, b int) int {
	if a >= b {
		return a
	}

	return b
}