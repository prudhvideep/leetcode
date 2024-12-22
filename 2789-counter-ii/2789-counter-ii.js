/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function (init) {
  let initVal = init
  return {
    increment: () => {
      initVal++
      return initVal
    },
    decrement: () => {
      initVal--
      return initVal
    },
    reset: () => {
      initVal = init
      return initVal
    }
  }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */