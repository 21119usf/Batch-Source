var homework={};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
    
n1=0;
n2=1;
if (n==1){
    sum=n1;
}
else if (n==2){
    sum=n2;
}
else{
for (i=0;i<n-2;i++){
sum=n1+n2;
n1=n2;
n2=sum;
}
}
console.log(sum)
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
for (j=1;j<=array.length-1;j++){
    for (i=0;i<array.length;i++){
        if (array[i]>array[i+1]){
            temp = array[i];
            array[i]=array[i+1];
            array[i+1]=temp;
        }
    }
}
console.log(array);
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
    if (n==0){
        product=1;
    }
    else{
    product=n;
for (i=n;i>1;i--){
    product=product*(i-1);
}
    }
console.log(product)
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {


arrlength=array.length;
var arrtemp=[];


for (i=0;i<arrlength;i++){
    
    j=(i+(arrlength-(n%arrlength)))%arrlength;
    arrtemp[j]=array[i];


}
console.log("f([" + array + "], " + n+ ") = [" + arrtemp+ "]");
};
