var TimeLimitedCache = function() {
    
};

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */

 let map = new Map()
 let tmap = new Map()
TimeLimitedCache.prototype.set = function(key, value, duration) {
    let exists = false
    if(map.has(key)){
      exists = true
      clearTimeout(tmap.get(key))
    }

    map.set(key,value)
    
    let tid = setTimeout(() => {
      map.delete(key)
    },duration)

    tmap.set(key,tid)

    return exists
};

/** 
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    if(map.has(key)){
      return map.get(key)
    }

    return -1
};

/** 
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    return map.size
};

/**
 * const timeLimitedCache = new TimeLimitedCache()
 * timeLimitedCache.set(1, 42, 1000); // false
 * timeLimitedCache.get(1) // 42
 * timeLimitedCache.count() // 1
 */