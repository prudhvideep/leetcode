func minimizeXor(num1 int, num2 int) int {
	n1 := make([]int, 32)
	n2 := make([]int, 32)

	c1, c2 := 0, 0
	for i := 0; i < 32; i++ {
		mask := (1 << i)
		n1[i] = (num1 & mask) / mask
		if n1[i] == 1 {
			c1++
		}
	}

	for i := 0; i < 32; i++ {
		mask := (1 << i)
		n2[i] = (num2 & mask) / mask

		if n2[i] == 1 {
			c2++
		}
	}

	res := make([]int, 32)

	if c1 == c2 {
		return num1
	}


	for i := 31; i >= 0; i-- {
		if i+1 > c2 && n1[i] == 1 && c2 > 0 {
			res[i] = 1
			c2--
		}
	}

	for i := 0; i < c2; i++ {
		res[i] = 1
	}

	nRes := 0
  // fmt.Println("Res --> ",res)

	for i := 0; i < 32; i++ {
		p := (1 << i)

		nRes += (p * res[i])
	}

	return nRes

}