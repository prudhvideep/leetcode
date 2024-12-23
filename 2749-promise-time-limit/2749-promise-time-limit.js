/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function (fn, t) {

  return async function (...args) {
    return new Promise((resolve, reject) => {
      Promise.race([new Promise((rs, rj) => {
        fn(...args).then((data) => rs(data))
        .catch((error) => rj(error))
      }), new Promise((rs1, rj1) => {
        setTimeout(() => {
          rj1("Time Limit Exceeded")
        }, t)
      })]).then((data) => resolve(data))
      .catch((error) => reject(error))

    })
  }
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */