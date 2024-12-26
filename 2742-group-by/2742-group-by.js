/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function (fn) {

  const obj = {}


  for (let e of this) {
    if(!obj[fn(e)]){
      obj[fn(e)] = [];
    }
    obj[fn(e)].push(e); 
  }

  return obj;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */