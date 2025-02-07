func queryResults(limit int, queries [][]int) []int {
	bmp := make(map[int]int)
	result := make([]int, len(queries))

	mp := make(map[int]int)

	for i, q := range queries {
		x := q[0]
		y := q[1]

		if _,ok := bmp[x]; !ok {
      mp[y]++
    }else {
      pc := bmp[x]
      delete(bmp,x)
      mp[pc]--

      if mp[pc] <= 0 {
        delete(mp,pc)
      }
      mp[y]++
    }
    bmp[x] = y

    result[i] = len(mp)
 	}

	return result
}