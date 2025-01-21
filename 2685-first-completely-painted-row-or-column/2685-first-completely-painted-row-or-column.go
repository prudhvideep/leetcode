func firstCompleteIndex(arr []int, mat [][]int) int {
    mp := make(map[int][2]int)

    for i := 0; i < len(mat);i++ {
      for j := 0; j < len(mat[0]); j++ {
        key := mat[i][j]
        mp[key] = [2]int{i,j}
      }
    }

    row := make([]int,len(mat))
    col := make([]int,len(mat[0]))
    
    idx := -1
    loop:
    for i,ele := range arr {
      l := mp[ele]

      x,y := l[0], l[1]
      row[x]++
      col[y]++

      if (row[x] == len(mat[0])) || (col[y] == len(mat)) {
        idx = i
        break loop
      }
    }
    
    return idx;
}