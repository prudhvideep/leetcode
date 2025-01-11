func canConstruct(s string, k int) bool {
	mp := make(map[string]int)

  if len(s) < k {
    return false
  }

	for _, v := range s {
		mp[string(v)]++
	}

	for key, v := range mp {
		mul := 2
		for mul*k <= v {

			mul += 2
		}
		mp[key] = v - (max(mul-2, 2) * k)

		if mp[key] == 0 {
			delete(mp, key)
		}
	}

	oc, ec := 0, 0
	for _, v := range mp {
		if v%2 == 0 {
			ec++
		} else {
			oc++
		}
	}

	// if ec%k != 0 {
	// 	return false
	// }

	if oc > k {
		return false
	}

	return true
}

func max(a, b int) int {
	if a >= b {
		return a
	}

	return b
}