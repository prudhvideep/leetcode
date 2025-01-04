/**
 * @param {number[]} nums
 * @return {void}
 */
var ArrayWrapper = function (nums) {
  this.args = nums
};

/**
 * @return {number}
 */
ArrayWrapper.prototype.valueOf = function () {
  let sum = 0
  for (let e of this.args) {
    if (e) {
      sum += e
    }
  }


  return sum
}

/**
 * @return {string}
 */
ArrayWrapper.prototype.toString = function () {
  let str = "["
  for (let i = 0; i < this.args.length - 1; i++) {
    str += this.args[i]
    str += ","
  }
  if (this.args[this.args.length - 1]) {
    str += this.args[this.args.length - 1]
  }

  str += "]"

  return str
}

/**
 * const obj1 = new ArrayWrapper([1,2]);
 * const obj2 = new ArrayWrapper([3,4]);
 * obj1 + obj2; // 10
 * String(obj1); // "[1,2]"
 * String(obj2); // "[3,4]"
 */