func waysToSplitArray(nums []int) int {
    splits := 0
    n := len(nums)
    ps := make([]int,n)

    for i := range nums {
      if i == 0 {
        ps[i] = nums[i]
        continue
      }

      ps[i] = nums[i] + ps[i-1]
    }

    for i := 0; i < n-1;i++ {
      ls := ps[i]
      rs := ps[n-1] - ps[i]

      if ls >= rs {
        splits++
      }
    }

    return splits
}