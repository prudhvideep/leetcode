/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    let result = {}

    arr1.forEach((ele) => {result[ele.id] = ele})

    arr2.forEach((ele) => {
      if(result[ele.id]){
        result[ele.id] = {
          ...result[ele.id],
          ...ele
        }
      }else{
        result[ele.id] = ele;
      }
    })

    return Object.values(result);
};