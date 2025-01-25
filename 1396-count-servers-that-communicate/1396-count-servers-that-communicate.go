func countServers(grid [][]int) int {
	r := len(grid)
	c := len(grid[0])

	visited := make([][]bool, r)
	for i := 0; i < r; i++ {
		visited[i] = make([]bool, c)
	}

  totCount := 0

	for i := 0; i < r; i++ {
		count := 0
		temp := make([]bool, c)
		for j := 0; j < c; j++ {

			if grid[i][j] == 1 {
				count++
				temp[j] = true
			}
		}

    if count > 1 {
      copy(visited[i],temp)
      totCount += count
    }
	}

  for i := 0;i < c;i++ {
    uvis := 0
    count := 0
    for j := 0; j < r;j++ {
      if grid[j][i] == 1 {
				count++

        if !visited[j][i] {
          uvis++
        }
			}
    }

    if count > 1 {
      totCount += uvis
    }
  }

  return totCount
}