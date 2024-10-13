func maxWidthRamp(nums []int) int {
	n := len(nums)
	maxVal := make([]int, len(nums))

	maxVal[n-1] = nums[n-1]

	for i := len(nums) - 2; i >= 0; i-- {
		maxVal[i] = max(nums[i], maxVal[i+1])
	}
  

	l, r, mw := 0, 0, 0

	for r < n {
		for (l <= r) && (r < n) && (nums[l] <= maxVal[r]) {
      mw = max(mw,r-l)
      r++
		}
    l++
	}

  return mw
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}