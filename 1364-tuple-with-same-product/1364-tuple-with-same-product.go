type Pair struct {
	a, b int
}

func tupleSameProduct(nums []int) int {
	mp := make(map[int][]Pair)

	for i := 0; i < len(nums)-1; i++ {
		for j := i + 1; j < len(nums); j++ {
			prod := nums[i] * nums[j]

			pair := Pair{
				a: nums[i],
				b: nums[j],
			}

			if _, ok := mp[prod]; ok {
				mp[prod] = append(mp[prod], pair)
			} else {
				mp[prod] = append(mp[prod], pair)
			}
		}
	}

	tuples := 0

	for _, v := range mp {
		if len(v) > 1 {
			l := len(v)

			n := ((l*(l - 1)) / 2)
      
      tuples += n*8
		}
	}

	return tuples
}