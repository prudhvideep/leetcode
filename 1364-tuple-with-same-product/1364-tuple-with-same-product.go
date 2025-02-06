
func tupleSameProduct(nums []int) int {
	mp := make(map[int]int)

	for i := 0; i < len(nums)-1; i++ {
		for j := i + 1; j < len(nums); j++ {
			prod := nums[i] * nums[j]

			mp[prod]++
		}
	}

	tuples := 0

	for _, n := range mp {
		tuples += n * (n-1) * 8
	}

	return tuples/2
}