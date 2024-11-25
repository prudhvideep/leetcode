function maxMatrixSum(matrix: number[][]): number {
    let totSum = 0;
    let nCount = 0, le = Number.MAX_VALUE;

    for(let row of matrix){
      for (let ele of row){
        if(ele <= 0){
          nCount++;
        }

        totSum += Math.abs(ele);
        le = Math.min(le,Math.abs(ele));
      }
    }

    if(nCount%2 !== 0){
      totSum -= (2*le);
    }

    return totSum;

};