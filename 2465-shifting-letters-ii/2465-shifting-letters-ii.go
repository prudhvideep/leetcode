func shiftingLetters(s string, shifts [][]int) string {
	n := len(s)
	diff := make([]int, n)

	for _, shift := range shifts {
		l := shift[0]
		h := shift[1]

		inc := shift[2]

		if inc == 1 {
			diff[l] += 1

			if h+1 < n {
				diff[h+1] -= 1
			}
		} else {
			diff[l] -= 1

			if h+1 < n {
				diff[h+1]++
			}
		}
	}

	sbuf := strings.Builder{}
	ns := 0

	for i := 0; i < n; i++ {
		ns = (ns + diff[i]) % 26

		if ns < 0 {
			ns += 26
		}

		newChar := (int(s[i])-'a'+ns)%26 + 'a'

		sbuf.WriteByte(byte(newChar))

	}

	return sbuf.String()
}