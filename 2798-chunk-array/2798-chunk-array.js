/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function(arr, size) {
    let retArr = []
    let cArr = []

    for(let e in arr){
      if(cArr.length < size){
        cArr.push(arr[e])
      }else{
        retArr = [...retArr,cArr]
        cArr = new Array()
        cArr.push(arr[e])
      }  
    }

    if(cArr.length != 0){
      retArr = [...retArr,cArr]
    }

    return retArr
};
