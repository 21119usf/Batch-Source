function calcFib(num) {
    var prev = 0;
    var curr = 1;
    var next = 1;

    if (num == 0) {
        return prev;
    }
    else {
        for (let i = 1; i < num; i++) {
            next += prev;
            prev = curr;
            curr = next;
        }
        return next;
    }
}

console.log("\nTesting calcFib()============================")
console.log("F(0) = " + calcFib(0));
console.log("F(1) = " + calcFib(1));
console.log("F(10) = " + calcFib(10));

function sortArray(array) {
    var maxVal;
    var maxIndex;

    for (let i = array.length - 1 ; i > 0; i--) {
        maxVal = array[0];
        maxIndex = 0;
        for (let j = 0; j < i; j++) {
            if (array[j] >= maxVal) {
                maxVal = array[j];
                maxIndex = j;
            }
        }
        array[maxIndex] = array[i];
        array[i] = maxVal;
    }
    return array;
}

console.log("\nTesting sortArray()=========================")
var myArray1 = [2,4,5,1,3,1];
console.log("Before Sort: " + myArray1);
sortArray(myArray1);
console.log("After Sort: " + myArray1);


function calcFactorial(num) {
    var product = 1;

    while (num > 1) {
        product *= num--;
    }

    return product;
}

console.log("\nTesting calcFactorial()==================")
console.log("f(0) = " + calcFactorial(0));
console.log("f(1) = " + calcFactorial(1));
console.log("f(3) = " + calcFactorial(3));

function rotateLeft(array, n) {
    var newArray = new Array();
    var startingIndex = n % array.length;
    var moveFrom;

    if (startingIndex == 0) { //skip processing since it will be the same array anyways
        return array;
    }

    for (let i = 0; i < array.length; i++) {
        moveFrom = (i + startingIndex) % array.length; //this line handles wrap around of the array
        newArray.push(array[moveFrom]);
    }

    return newArray;
}

console.log("\nTesting rotateLeft()============================")
var myArray2 = [1,2,3,4,5];
console.log("Rotate by 1: " + rotateLeft(myArray2, 1));
console.log("Rotate by 6: " + rotateLeft(myArray2, 6));
console.log("Rotate by 3: " + rotateLeft(myArray2, 3));

function areBalanced(myString) {
    var myArray = new Array();
    var tempString = new String();
    tempString = myString;
    var isBalanced = true;
    var token;

    for (let i = 0; i < myString.length; i++) {
        token = tempString.charAt(0);
        //If we have an opening bracket, add it to the top of our stack
        if (token == '{' || token == '(' || token == '[') {
            myArray.push(token);         //add the item to our 'stack'
            tempString = tempString.substr(1);          //remove the token from the string
        }
        //If we have a closing bracket, compare to see if the token matches the opening bracket at the top of our stack
        else if ((myArray[myArray.length-1] == '{' && token == '}') 
                || (myArray[myArray.length-1] == '(' && token == ')')
                || (myArray[myArray.length-1] == '[' && token == ']')) {
            myArray.pop();
            tempString = tempString.substr(1);
        }
        else { //should only get here if we found a closing bracket AND it did not match the opening bracket at the top of the stack
            isBalanced = false;
            break;
        }
    }
    if (myArray.length != 0) { //this triggers if we still has opening brackets on our stack that were never completed
        isBalanced = false;
    }
    return isBalanced;
}

console.log("\nTesting areBalanced()============================")
console.log("'()' is balanced: " + areBalanced("()"));
console.log("'()()' is balanced: " + areBalanced("()()"));
console.log("'(())' is balanced: " + areBalanced("(())"));
console.log("'({[]})' is balanced: " + areBalanced("({[]})"));

console.log("'(' is balanced: " + areBalanced("("));
console.log("')' is balanced: " + areBalanced(")"));
console.log("'(()' is balanced: " + areBalanced("(()"));
console.log("'([)]' is balanced: " + areBalanced("([)]"));