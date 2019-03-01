var homework = {};

/*
1. Return the nth fibonacci number
f(0) = 0
f(1) = 1
f(10) = 55
*/
homework.fibonacci = function(n) {
	if (n == 0 || n == 1) {
		return n;
	} else {
		return homework.fibonacci(n - 1) + homework.fibonacci(n - 2);
	}
};

console.log("fibonacci");
console.log("---------");
console.log("f(0) = " + homework.fibonacci(0));
console.log("f(1) = " + homework.fibonacci(1));
console.log("f(10) = " + homework.fibonacci(10));

/*
2. Sort array of integers
f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
	for (let i = 0; i < array.length - 1; i++) {
		for (let j = 0; j < array.length - i - 1; j++) {
			if (array[j] > array[j + 1]) {
				let temp = array[j];
				array[j] = array[j + 1];
				array[j + 1] = temp;
			}
		}
	}

	return array;
};

console.log();
console.log("sort");
console.log("----");
console.log("f([2,4,5,1,3,1]) = " + homework.sort([2,4,5,1,3,1]));

/*
3. Return the factorial of n
f(0) = 1
f(1) = 1
f(3) = 6
*/
homework.factorial = function(n) {
	if (n == 0) {
		return 1;
	}

	let fact = 1;

	for (let i = 1; i <= n; i++) {
		fact *= i;
	}

	return fact;
};

console.log();
console.log("factorial");
console.log("---------");
console.log("f(0) = " + homework.factorial(0));
console.log("f(1) = " + homework.factorial(1));
console.log("f(3) = " + homework.factorial(3));

/*
4. Rotate left
Given array, rotate left n times and return array
f([1,2,3,4,5], 1) = [2,3,4,5,1]
f([1,2,3,4,5], 6) = [2,3,4,5,1]
f([1,2,3,4,5], 3) = [4,5,1,2,3]
*/
homework.rotateLeft = function(array, n) {
	for (let i = 0; i < n; i++) {
		let temp = array.shift();
		array.push(temp);
	}

	return array;
};

console.log();
console.log("rotateLeft");
console.log("----------");
console.log("f([1,2,3,4,5], 1) = " + homework.rotateLeft([1,2,3,4,5], 1));
console.log("f([1,2,3,4,5], 6) = " + homework.rotateLeft([1,2,3,4,5], 6));
console.log("f([1,2,3,4,5], 3) = " + homework.rotateLeft([1,2,3,4,5], 3));

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
	if (bracketsString.length % 2 != 0) {
		return false;
	}

	var stack = [];
	
	for (let i = 0; i < bracketsString.length; i++) {
		if (bracketsString[i] == "(" || bracketsString[i] == "{" || bracketsString[i] == "[") {
			stack.push(bracketsString[i]);
		} else {
			let pop = stack.pop();
			if ((bracketsString[i] == ")" && pop != "(") || (bracketsString[i] == "}" && pop != "{") || (bracketsString[i] == "]" && pop != "[")) {
				return false;
			}
		}
	}

	return true;
};

console.log();
console.log("balancedBrackets");
console.log("----------------");
console.log("(): " + homework.balancedBrackets("()"));
console.log("()(): " + homework.balancedBrackets("()()"));
console.log("(()): " + homework.balancedBrackets("(())"));
console.log("({[]}): " + homework.balancedBrackets("({[]})"));
console.log("(: " + homework.balancedBrackets("("));
console.log("): " + homework.balancedBrackets(")"));
console.log("((): " + homework.balancedBrackets("(()"));
console.log("([)]: " + homework.balancedBrackets("([)]"));