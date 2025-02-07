func largestIsland(grid [][]int) int {
	r, c := len(grid), len(grid[0])
	mp := make(map[int]int)
	count := 2

	for i := 0; i < r; i++ {
		for j := 0; j < c; j++ {
			if grid[i][j] == 1 {
				area := 0
				dfs(i, j, &grid, count, &area)
				mp[count] = area
				count++
			}
		}
	}

	// fmt.Println(mp)

	maxArea := 0
	hasWater := false

	for i := 0; i < r; i++ {
		for j := 0; j < c; j++ {
			if grid[i][j] == 0 {
				hasWater = true
				area := 1
				visited := make(map[int]bool)

				if i-1 >= 0 && grid[i-1][j] > 0 {
					if _, ok := visited[grid[i-1][j]]; !ok {
						area += mp[grid[i-1][j]]
					}
					visited[grid[i-1][j]] = true
				}

				if i+1 < r && grid[i+1][j] > 0 {
					if _, ok := visited[grid[i+1][j]]; !ok {
						area += mp[grid[i+1][j]]
					}
					visited[grid[i+1][j]] = true
				}

				if j-1 >= 0 && grid[i][j-1] > 0 {
					if _, ok := visited[grid[i][j-1]]; !ok {
						area += mp[grid[i][j-1]]
					}
					visited[grid[i][j-1]] = true
				}

				if j+1 < c && grid[i][j+1] > 0 {
					if _, ok := visited[grid[i][j+1]]; !ok {
						area += mp[grid[i][j+1]]
					}
					visited[grid[i][j+1]] = true
				}

				maxArea = max(area, maxArea)
			}
		}
	}
	if !hasWater {
		return r * c
	}

	return maxArea
}

func dfs(i, j int, grid *[][]int, count int, area *int) {
	*area++
	gd := *grid
	gd[i][j] = count

	r, c := len(gd), len(gd)

	if i-1 >= 0 && gd[i-1][j] == 1 {
		dfs(i-1, j, grid, count, area)
	}

	if i+1 < r && gd[i+1][j] == 1 {
		dfs(i+1, j, grid, count, area)
	}

	if j-1 >= 0 && gd[i][j-1] == 1 {
		dfs(i, j-1, grid, count, area)
	}

	if j+1 < c && gd[i][j+1] == 1 {
		dfs(i, j+1, grid, count, area)
	}
}

func max(a, b int) int {
	if a >= b {
		return a
	}

	return b
}