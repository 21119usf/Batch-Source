// Homework object
let homework = () => {};

// Return the nth fibonacci number
homework.fibonacci = (n) => {
    if (n <= 1) {
        return n;
    }
    return homework.fibonacci(n-1) + homework.fibonacci(n-2);
};

// Sort an array of integers
homework.sort = (array) => {
    for (i=0; i<array.length-1; i++) {
        for (j=0; j<array.length-i-1; j++) {
            if (array[j] > array[j+1]) {
                tmp = array[j];
                array[j] = array[j+1];
                array[j+1] = tmp;
            }
        }
    }
    return array;
};

// Return n-factorial
homework.factorial = (n) => {
    if (n == 0 || n == 1) {
        return 1;
    }

    let result = 1;
    for (i=n; i>0; i--) {
        result *= i;
    }

    return result;
};

// Rotate array left, n times
homework.rotateLeft = (array, n) => {
    for (i=0; i<n; i++) {
        temp = array.shift();
        array.push(temp);
    }
    return array;
};

// Check if brackets are balanced
homework.balancedBrackets = (bracketsString) => {
    if (bracketsString.length % 2 != 0) {
        return false;
    }

    let stack = [];
    stack.push(bracketsString.charAt(0));
    for (i=1; i<bracketsString.length; i++) {
        let bracket = bracketsString.charAt(i);
        if ((stack[i-1] == '[' && bracket != ']') || 
        (stack[i-1] == '(' && bracket != ')') ||
        (stack[i-1] == '{' && bracket != '}')) {
            stack.push(bracket);
        } else {
            stack.pop();
        }
    }

    return stack.length == 0 ? true : false;
};
