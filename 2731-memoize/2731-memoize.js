/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    const map = new Map()
    return function(...args) {
        if(map.get([...args].join(",")) === undefined){
          map.set([...args].join(","),fn(...args))
        }
        return map.get([...args].join(","))
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */