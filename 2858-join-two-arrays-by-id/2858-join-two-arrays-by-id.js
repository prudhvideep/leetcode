/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    let set2 = new Set(arr2.map((ele) => ele.id));
    let map1 = new Map(arr1.map((ele,id) => [ele.id , id]));

    let retArr = arr1.filter((ele) => {
      if(set2.has(ele.id)){
        return false;
      }

      return true;
    })

    arr2.forEach((ele) => {
      if(map1.has(ele.id)){
        let ele1 = arr1[map1.get(ele.id)]
        let newEle = {
         ...ele1,
         ...ele
        }

        retArr.push(newEle);
        return;
      }
      retArr.push(ele);
    })

    retArr.sort((a,b) => a.id - b.id)

    return retArr
};