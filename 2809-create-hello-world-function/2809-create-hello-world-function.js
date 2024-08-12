/**
 * @return {Function}
 */
var createHelloWorld = function() {
    
    return function(...args) {
        let str = "Hello World"
        return str
    }
};

/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */