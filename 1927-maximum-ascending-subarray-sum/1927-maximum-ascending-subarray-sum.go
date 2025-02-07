func maxAscendingSum(nums []int) int {
    maxSum := nums[0]

    sum := nums[0]
    for i := 1; i < len(nums); i++ {
      if nums[i] > nums[i-1] {
        sum += nums[i]
      }else {
        sum = nums[i]
      }

      maxSum = max(maxSum,sum)
    }

    return maxSum
}

func max(a,b int)int {
  if a >= b {
    return a
  }
  return b
}