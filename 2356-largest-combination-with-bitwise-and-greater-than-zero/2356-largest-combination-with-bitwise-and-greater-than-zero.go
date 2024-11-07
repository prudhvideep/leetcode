func largestCombination(candidates []int) int {
    count,maxCt := 0,0

    maxE := slices.Max(candidates)

    for b := 1; b <= maxE; b = b << 1 {
      count = 0

      for _,e := range candidates{
        if b & e > 0 {
          count++
        }
      }

      if count > maxCt{
        maxCt = count
      }
    } 

    return maxCt
}