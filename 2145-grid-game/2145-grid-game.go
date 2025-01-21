func gridGame(grid [][]int) int64 {
  var sRowSum int64 = 0 

  var fRowTot int64 = 0
  for i := 0;i < len(grid[0]); i++ {
    fRowTot += int64(grid[0][i])
  }

  var minPoints int64
  minPoints = 10000000000

  for i := 0; i < len(grid[0]); i++ {
    fRowTot -= int64(grid[0][i])
    ms := max(sRowSum,fRowTot)
    minPoints = min64(ms,minPoints)
    sRowSum += int64(grid[1][i])
  }
  
  return minPoints
}

func min64(a,b int64) int64 {
  if a >= b {
    return b
  }
  return a
}

func max(a,b int64) int64 {
  if a >= b {
    return a
  }

  return b
}