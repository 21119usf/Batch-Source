var homework = {};
//QUESTON 1
homework.fibonacci = function(n){
  if(n === 1 || n === 0)
    return n;
  return homework.fibonacci(n-1) + homework.fibonacci(n-2);
}
console.log(homework.fibonacci(0));
console.log(homework.fibonacci(1));
console.log(homework.fibonacci(10));
//QUESTION 2
homework.sort = function(array){
  var n = array.length;
  for(var i = 0; i < n - 1; i++){
    for(var j = i + 1; j < n; j++){
        if(array[i] >= array[j]){
            var temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }
    }
  }
  return array;
};
var array1 = [2,4,5,1,3,1];
console.log(homework.sort(array1));

//QUESSTION 3
homework.factorial = function(n){
  if(n === 1 || n === 0)
    return 1;
  return n*homework.factorial(n-1);
}

console.log(homework.factorial(0));
console.log(homework.factorial(0));
console.log(homework.factorial(3));

//QUESTION 4
homework.rotateLeft = function(array, n){
  for(var i = 0; i < n; i++){
    var temp = array[0];
    for(var j = 0; j < array.length-1; j++){
      array[j] = array[j+1];
    }
    array[j] = temp;
  }
  return array;
}

var temp = [1,2,3,4,5];
console.log(homework.rotateLeft(temp, 1));
var temp = [1,2,3,4,5];
console.log(homework.rotateLeft(temp, 6));
var temp = [1,2,3,4,5];
console.log(homework.rotateLeft(temp, 3));*/
//QUESTION 5
homework.balancedBrackets = function(bracketsString){
var firsthalf = '';
var secondhalf = '';
var len = bracketsString.length;

if(len == 0|| len%2 == 1)
  return false;

for(var i = 0; i < len; i++){
    var check = bracketsString.charAt(i);
    if(check==='('||check===')'||check==='{'||check==='}'||check==='['||check ===']')
      continue;
    else
      return false;
  }

  for(var i = 0; i < len/2; i++){
    firsthalf = bracketsString.charAt(i);
    secondhalf = bracketsString.charAt(len-1-i);
    if(firsthalf == secondhalf)
      return false;
    else{
      var char = bracketsString.charAt(len-1-i)
      if(bracketsString.charAt(i) === inverBracket(char))
        continue;
      else
        return false;
    }
  }
  return true;
}

inverBracket = function(char){
  if(char === '}'){
    char = '{';
    return char;
  }
  if(char === '{'){
    char = '}';
    return char;
  }
  if(char === ')'){
    char = '(';
    return char;
  }
  if(char === '('){
    char = ')';
    return char;
  }
  if(char === ']'){
    char = '[';
    return char;
  }
  if(char === '['){
    char = ']';
    return char;
  }
}

var s1 = '()';
console.log(homework.balancedBrackets(s1));
var s2 = '()()';
console.log(homework.balancedBrackets(s2));
var s3 = '(())';
console.log(homework.balancedBrackets(s3));
var s4 = '({[]})';
console.log(homework.balancedBrackets(s4));
var s5 = '(';
console.log(homework.balancedBrackets(s5));
var s6 = ')';
console.log(homework.balancedBrackets(s6));
var s7 = '(()';
console.log(homework.balancedBrackets(s7));
var s8 = '([)]';
console.log(homework.balancedBrackets(s8));
