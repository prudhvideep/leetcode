/**
 * @param {number} millis
 * @return {Promise}
 */
async function sleep(millis) {
  return new Promise((resolve,reject) => {
    setTimeout(() => resolve(10),millis)
  })
}

/** 
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */