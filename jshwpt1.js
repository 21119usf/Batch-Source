var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
    // the first 2 numbers in the sequences are automatic and not done by operations
    if (n === 0) { return 0}
    if (n === 1) { return 1}

    sum = 1
    previousVal = 1

    for (i = 2; i < n; i++) {
        let lastSum = sum
        sum += previousVal
        previousVal = lastSum
    }
    return sum
};

console.log("Fibonacci of 10: " + homework.fibonacci(10))

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
    for (i = 0; i < array.length; i ++) {
        for (j = 0; j < array.length; j++) {
            if (array[i] < array[j]) {
                let tempI = array[i]
                let tempJ = array[j]
                array[i] = tempJ
                array[j] = tempI
            }
        }
    }
    return array;
};

console.log("Sorted Array [2,4,5,1,3,1] " + homework.sort([2,4,5,1,3,1]))

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
    if (n === 0 ) {return 1}
    sum = 0;
    for (i = 1; i <= n; i ++) {
        sum+=i;
    }
    return sum;
};

console.log("Factorial of 0: "  + homework.factorial(0))
console.log("Factorial of 1: " +homework.factorial(1))
console.log("Factorial of 3: " +homework.factorial(3))

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
    for (i = 0; i < n; i++) {
        let removedEntry = array.shift()
        array.push(removedEntry)
    }
    return array
};

console.log("Rotated Left 1: " + homework.rotateLeft([1,2,3,4,5], 1))
console.log("Rotated Left 6: " + homework.rotateLeft([1,2,3,4,5], 6))
console.log("Rotated Left 3: " + homework.rotateLeft([1,2,3,4,5], 3))

/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()
    ()()
    (())
    ({[]})

 The following are NOT balanced brackets:
 (
 )
 (()
 ([)]

 Return true if balanced
 Return false if not balanced
*/
homework.balancedBrackets = function(bracketsString){
    for (i = 0; i < bracketsString.length; i++) {
        if (
            bracketsString[i] != "(" &&
            bracketsString[i] != ")" &&
            bracketsString[i] != "{" &&
            bracketsString[i] != "}" &&
            bracketsString[i] != "[" &&
            bracketsString[i] != "]"
            ) {
                return false;
            } else {
                if (bracketsString[i] != 
                    reverseChar(bracketsString[bracketsString.length - (i +1)])) {
                    return false;
                }
            }
    }
    return true;
};

function reverseChar(char) {
    if (char == "(") { return ")"} 
    if (char == ")") { return "("} 
    if (char == "{") { return "}"} 
    if (char == "}") { return "{"}
    if (char == "[") {return "]"} 
    if (char == "]") {return "["} 
}

console.log("Balanced Brackets Test (): " + homework.balancedBrackets("()"))
console.log("Balanced Brackets Test ()(): " + homework.balancedBrackets("()()"))
console.log("Balanced Brackets Test (()): " + homework.balancedBrackets("(())"))
console.log("Balanced Brackets Test (({[]})): " + homework.balancedBrackets("(({[]}))"))
console.log("Balanced Brackets Test (: " + homework.balancedBrackets("("))
console.log("Balanced Brackets Test ): " + homework.balancedBrackets(")"))
console.log("Balanced Brackets Test ((): " + homework.balancedBrackets("(()"))
console.log("Balanced Brackets Test ([)]: " + homework.balancedBrackets("([)]"))