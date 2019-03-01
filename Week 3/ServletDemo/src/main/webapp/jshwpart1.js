var homework={};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
    
n1=1;
n2=1
for (i=0;i<n-2;i++){
sum=n1+n2;
n1=n2;
n2=sum;
}
console.log(sum)
};


