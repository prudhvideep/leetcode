func countBadPairs(nums []int) int64 {
    n := len(nums)

    tp := int64(n * (n-1))
    tp = tp/2

    mp := make(map[int]int)
    var gp int64
    gp = 0

    for i,e := range nums {
      mp[e-i]++
    }

    for _,v := range mp {
      if v > 1 {
        gp += getPairs(v)
      }
    }

    return tp - gp
}

func getPairs(n int) int64 {
  r := int64(n * (n-1))
  return r/2
}