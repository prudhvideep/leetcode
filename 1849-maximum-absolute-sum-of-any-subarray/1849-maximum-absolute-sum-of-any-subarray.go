func maxAbsoluteSum(nums []int) int {
  mPs := 0
   
  cSum := 0
  for _,n := range nums {
    cSum  += n 
    
    mPs = max(mPs,cSum)

    if cSum < 0 {
      cSum = 0
    }
  }

  cSum = 0
  for _,n := range nums {
    cSum += n 

    if cSum > 0 {
      cSum = 0
      continue
    }

    mPs = max(mPs,abs(cSum))

  }

  return mPs

}

func max(a,b int)int {
  if a >= b {
    return a
  }

  return b
}

func min(a,b int)int {
  if a <= b {
    return b
  }

  return a
}

func abs(a int) int {
  if a < 0 {
    return -1 * a
  }

  return a
}