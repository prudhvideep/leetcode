func maxMatrixSum(matrix [][]int) int64 {
    var totSum int64;
    var le int64 = math.MaxInt64;
    var nCount int64 = 0;

    for _,row := range matrix{
      for _,ele := range row{
        if(ele < 0){
          nCount++
          ele = -1 * ele
        }

        totSum += int64(ele)
        le = minEle(le,int64(ele))
      }
    }

    if nCount % 2 != 0{
      totSum -= (2 * le)
    }

    return totSum
}

func minEle(a,b int64) int64{
  if(a >= b){
    return b
  }

  return a
}