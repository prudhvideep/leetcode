func canConstruct(s string, k int) bool {
	if len(s) < k {
		return false
	}

	mp := make([]int, 26)

	for _, c := range s {
		mp[c-'a']++
	}

	oc := 0
	for _, v := range mp {
		if v%2 == 1 {
			oc++
		}
	}

	if oc > k {
		return false
	}

	return true

}