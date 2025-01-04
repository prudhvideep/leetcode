/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */


var flat = function (arr, n) {
  let fa = []
  helper(fa,arr, n)
  return fa;
};


function helper(fa,arr, n) {
  if (n < 0) {
    fa.push(arr)
    return
  }

  for (let ele of arr) {
    if (Array.isArray(ele)) {
      helper(fa,ele, n - 1)
    } else {
      fa.push(ele)
    }
  }
}