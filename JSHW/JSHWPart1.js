// JavaScript source code
var homework = {};
homework.fibonacci = function(n){
	if(n===0)return 0;
	else if(n===1)return 1;
	else{
		var i;
		var f1 = 0;
		var f2 = 1;
		var temp;
		for(i = 1; i < n; i++){
			temp = f1;
			f1 = f2;
			f2 = temp + f2;
		}
		return f2;
	}
};

homework.sort = function(array) {
	var isChanged = true;
	var i;
	var len = array.length;
	var temp;
	while(isChanged){
		isChanged = false;
		for(i=0;i<len-1;i++){
			if(array[i] > array[i+1]){
				temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
				isChanged = true;
			}		
		}
	}
	return array;
};

homework.factorial = function(n){
	if(n === 1)return 1;
	return n * homework.factorial(n-1);
};

homework.rotateLeft = function(array, n) {
	var len = array.length;
	var newArr = new Array(len);
	var i;
	var j;
	for(i = 0; i < len ; i++){
		n = n%len;
		j = (i+(len-n))%len;
		newArr[j] = array[i];
	}
	return newArr;
};

homework.balancedBrackets = function(bracketsString){
	var stack = new Array();
	var i;
	for(i=0;i<bracketsString.length;i++){
		curChar = bracketsString[i];
		if(curChar == '(' || curChar == '{' || curChar == '['){
			stack.push(curChar);
		}else if(curChar == ')' && stack[stack.length -1] == '('){
			stack.pop();
		}else if(curChar == '}' && stack[stack.length -1] == '{'){
			stack.pop();
		}else if(curChar == ']' && stack[stack.length -1] == '['){
			stack.pop();
		}else{
			return false;
		}
	}
	if(stack.length == 0){
		return true;
	}
	return false;
};

