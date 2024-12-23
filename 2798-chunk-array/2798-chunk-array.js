/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function(arr, size) {
    let retArr = []
    
    for(let i = 0;i < arr.length; i+=size){
      retArr.push(arr.slice(i,i+size))
    }

    return retArr;
};
