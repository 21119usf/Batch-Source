console.log("Hello World");

function calcFactorial(num) {
    var product = 1;

    while (num > 1) {
        product *= num--;
    }

    return product;
}

console.log("Factorial of 10: " + calcFactorial(6));