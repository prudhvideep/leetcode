func compressedString(word string) string {
	l, h, c := 0, 1, 1

	var str strings.Builder

	for h < len(word) {
		if (word[l] == word[h]) && (c < 9) {
			c++
		} else {
			str.WriteString(strconv.Itoa(c))
			str.WriteByte(word[l])
			c = 1
			l = h
		}

		h++
	}

	str.WriteString(strconv.Itoa(c))
	str.WriteByte(word[l])

	return str.String()
}