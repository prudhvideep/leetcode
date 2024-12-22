/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function (functions) {

  return function (x) {
    let revFns = [...functions].reverse()

    return revFns.reduce((acc,fun) => fun(acc),x)
  }
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */