func isArraySpecial(nums []int) bool {
    for i := 0; i < len(nums)-1;i++ {
      if (isOdd(nums[i]) && isOdd(nums[i+1])) ||  (isEven(nums[i]) && isEven(nums[i+1])) {
        return false
      }
    }

    return true
}

func isOdd(num int) bool {
  return ((num%2) != 0)
}

func isEven(num int) bool {
  return ((num%2) == 0)
}