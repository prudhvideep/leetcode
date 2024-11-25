function maxMatrixSum(matrix: number[][]): number {
    let totSum = 0;
    let nCount = 0, le = Number.MAX_VALUE;

    for(let i = 0;i < matrix.length;i++){
      for (let j = 0; j < matrix[i].length;j++){
        if(matrix[i][j] <= 0){
          nCount++;
        }

        totSum += Math.abs(matrix[i][j]);
        le = Math.min(le,Math.abs(matrix[i][j]));
      }
    }

    if(nCount%2 !== 0){
      totSum -= (2*le);
    }

    return totSum;

};