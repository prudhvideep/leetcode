func largestCombination(candidates []int) int {
    sum := make([]int,32)

    for _,c := range candidates{
      mask := 1

      for i := 0;i < 32;i++{
        sum[i] += ((c & (mask << i)) / (mask << i))
      }
    }

    maxL := 0

    for _,n := range sum{
      if n > maxL {
        maxL = n
      }
    }

    return maxL


}