/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function (fn) {

  const obj = {}

  for (let e of this) {
    const key = fn(e)
    if(!(key in obj)){
      obj[key] = [];
    }
    obj[key].push(e)
  }

  return obj;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */