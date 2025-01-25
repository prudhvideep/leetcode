type pair struct {
	i int
	j int
}

func minEle(a, b int) int {
	if a <= b {
		return a
	}

	return b
}

func bfs(q []pair, isWater [][]int, r,c int) [][]int {
	
  res := make([][]int,r)
  for i := 0; i < r;i++ {
    res[i] = make([]int,c)
  }
  
	visited := make(map[pair]bool)
	for len(q) > 0 {

		ele := q[0]
		q = q[1:]

		i, j := ele.i, ele.j
    visited[pair{i : i, j : j}] = true

		if isWater[i][j] == 1 {
			res[i][j] = 0
		}

		if i-1 >= 0 && !visited[pair{i: i - 1, j: j}] {
			if isWater[i-1][j] == 0 {
				if res[i-1][j] == 0 {
					res[i-1][j] = 1 + res[i][j]
				} else {
					res[i-1][j] = minEle(1+res[i][j], res[i-1][j])
				}
			}

			q = append(q, pair{i: i - 1, j: j})
			visited[pair{i: i - 1, j: j}] = true
		}

		if i+1 < r && !visited[pair{i: i + 1, j: j}] {
			if isWater[i+1][j] == 0 {
				if res[i+1][j] == 0 {
					res[i+1][j] = 1 + res[i][j]
				} else {
					res[i+1][j] = minEle(1+res[i][j], res[i+1][j])
				}
			}

			q = append(q, pair{i: i + 1, j: j})
			visited[pair{i: i + 1, j: j}] = true
		}

		if j-1 >= 0 && !visited[pair{i: i, j: j - 1}] {
			if isWater[i][j-1] == 0 {
				if res[i][j-1] == 0 {
					res[i][j-1] = 1 + res[i][j]
				} else {
					res[i][j-1] = minEle(1+res[i][j], res[i][j-1])
				}
			}
			q = append(q, pair{i: i, j: j - 1})
			visited[pair{i: i, j: j - 1}] = true
		}

		if j+1 < c && !visited[pair{i: i, j: j + 1}] {
			if isWater[i][j+1] == 0 {
				if res[i][j+1] == 0 {
					res[i][j+1] = 1 + res[i][j]
				} else {
					res[i][j+1] = minEle(1+res[i][j], res[i][j+1])
				}
			}
			q = append(q, pair{i: i, j: j + 1})
			visited[pair{i: i, j: j + 1}] = true
		}
	
	}

  return res

}

func highestPeak(isWater [][]int) [][]int {
	r := len(isWater)
	c := len(isWater[0])

  q := make([]pair, 0, (r * c))

	for i := 0; i < r; i++ {
		for j := 0; j < c; j++ {
			if isWater[i][j] == 1 {
				q = append(q,pair{i : i, j : j})
			}
		}
	}

  res := bfs(q,isWater,r,c)

	return res
}