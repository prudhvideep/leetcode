/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
  let filArr = []
  
  for(let i = 0;i < arr.length;i++){
    if(Boolean(fn(arr[i],i))){
      filArr.push(arr[i])
    }
  }

  return filArr
};