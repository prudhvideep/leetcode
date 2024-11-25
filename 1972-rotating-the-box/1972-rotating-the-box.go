func rotateTheBox(box [][]byte) [][]byte {
	m := len(box)
	n := len(box[0])

	for i := 0; i < m; i++ {
		l, r := n-2, n-1

		for l >= 0 && r >= 0 {
			if box[i][l] == '#' && box[i][r] == '.' {
				box[i][l] = '.'
				box[i][r] = '#'

				l--
				r--
			} else if box[i][l] == '.' && box[i][r] == '.' {
				l--
			} else if box[i][l] == '*' {
				r = l - 1
				l = l - 2
			} else if box[i][l] == '#' && box[i][r] == '#' {
				l--
				r--
			} else if box[i][r] == '#' || box[i][r] == '*' {
				l--
				r--
			}
		}

	}
	newBox := make([][]byte, n)

	for i := 0; i < n; i++ {
		newBox[i] = make([]byte, m)
	}

	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			newBox[i][j] = box[m-j-1][i]
		}
	}

	return newBox
}