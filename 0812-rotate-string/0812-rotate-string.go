func rotateString(s string, goal string) bool {
	n := len(s)

	for n > 0 {
		s = s[1:] + s[0:1]
		if s == goal {
			return true
		}

		n--
	}

	return false
}