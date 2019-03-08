JS HW, part 1:

Fill in the functions and submit them to your branch in a file called JSHWPart1.js
gp
var homework = {};

/*
1. Return the nth fibonacci number

f(0) = 0
f(1) = 1
f(10) = 55
*/
homework.fibonacci = function(n){
  var fu = [0,1];
	for (i = 1; i < n; i++) {
		fu.push(fu[i-1] + fu[i])
    	}
    return fu[n];
};

/*
2. Sort array of integers

f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

Don't use the Array sort() method... that would be lame.
My implementation uses the same algorithm as the .sort() method, I hope that's okay.
*/
homework.sort = function mergeSort(arr) {
  if (arr.length === 1) {
    return arr; // don't recurse atomic element
  }
  const mid = Math.floor(arr.length / 2);
  const left = arr.slice(0, mid); // left side of the array
  const right = arr.slice(mid); // right side of the array
  return merge(mergeSort(left),mergeSort(right)); // slice recursively
};

function  merge(arr1, arr2) {
  let result = [];
  let index1 = 0;
  let index2 = 0;

  while (index1 < arr1.length && index2 < arr2.length) {
    if (arr1[index1] < arr2[index2]) {
      result.push(arr1[index1]);
      index1++;
    } else {
      result.push(arr2[index2]);
      index2++;
    }
  }
  return result.concat(arr1.slice(index1)).concat(arr2.slice(index2));
};
mergeSort([2,4,5,1,3,1]) = [1,1,2,3,4,5]
/*
3. Return the factorial of n

f(0) = 1
f(1) = 1
f(3) = 6
*/
homework.factorial = function factorial(n) {
  var result  = [1]; //I know this is somewhat jank but the way I expected it to work didnt for some god forsaken reason
  for (i = 1; i < n; i++) {
  	result.push(result[i - 1] * (i + 1));
    }
  return result[result.length-1];
  }
};

/*
4. Rotate left

Given array, rotate left n times and return array

f([1,2,3,4,5], 1) = [2,3,4,5,1]
f([1,2,3,4,5], 6) = [2,3,4,5,1]
f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function rotateLeft(array,n) {
	if (n < 0) {
    	n = n % array.length + array.length;
    }
	rotato = []
    for (i = n % array.length; i < n % array.length + array.length; i++) {
    	rotato.push(array[i%array.length])
        }
    return rotato
}

};

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


  
};
