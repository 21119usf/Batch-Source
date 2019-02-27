//JavaScript is NOT related to Java
//not- compiled- interpreted
//Loosely typed= variable type are assigned at runtime
var a=10;
console.log(a);
a= "chaos";
console.log(a);
var b,c,d,e,f,g,h,e;
b="10";
c=true;
d= {};
e=null;
g=(0/0);
h=[];
i=function(){};
//Booleans-True&False|Truthy &Falsy
//Truthy- True, everything that isnt
//falsy,Can be an object

//Falsy- 0, Undefined,Null,False."",
//NaN

//Type Coercion
// console.log(5==5);//true
// console.log(5=="5"); //true
// console.log(5==="5");
// console.log("Tests:")
// console.log(false==1);
// console.log(false==0);
// console.log(true==1);
// console.log(true==12);
// console.log(false==1);

console.log(7+7+7);//21
console.log(7+7+'7');//147
console.log('7'+7+7); //777

//Objects in JS
//property-value pairs

//Object Literal
var person= {
    "name": "Jimmy",
    "age": 92
};

person.numOfFeet=2;
//Constructor
function Human(name, age){
    this.name=name;
    this.age=age;
}
var bill= new Human("bill",51);
//Marker function
function makeHuman(name,age){
    var h={};
    h.name=name;
    h.age=age;
    return h;
}
//Another Marker Funciton
function makeHuman2(name,age){
    var p={
        "name":name,
        "age":age
    }
    return p;
}
//Arrays
var arr=[10,20,30];
arr[9]=5;
arr[1000]= "Boo";
arr[4]=makeHuman("kevin",14);
//Functions! - 3 invocations
//function form- "this" refers to global object. in browser, it is the "window"
function divideByZero(kitty, cat){
    console.log("hey kitty cat");    
    return (kitty+cat);
}
//Constructor Form- "this" refers to the object being created
var conFunc= new function(a,b){
return a*b;
}
//Method- "this" refers to person
person.getInfo = function (){
    return this.age;
}

crazy= function( at, least, three){
    console.log(at);
    console.log(least);
    console.log(three);
    console.log(arguments[5]);
}
// Scopes
// Function Scope
// Things that are declared inside a function.
// Use the “var” keyword. If you leave out “var,” you’ll create an implicit global.
// Accessible only inside the function.
// Global Scope
// Declared outside of any function. Accessible anywhere.
// Shadowing - if multiple variables have the same name, JS will use the one that was 
//declared the most recently. Variable name clashes are bad. Difficult to debug and test.
//"let" does not escape blocks, "var" does
//Hoisting-moves declaration to top of scope
// WATCH OUT!!
// Implicit Globals - variables declared in functional scope without the “var” keyword, 
//unless you’re in strict mode.
// Generally, stay away from using globals.

//Closure- an inner function that has access to the outer function's variable(scope chain)
//has 3 scope chains:
//1. it has access to its own scope( variables defined between its curly braces)
//2. it has acess the outer function's varibles
//3. it has access to the global variables
// closure mimics encapsulation

//Build a reusable counter
// var count=0;
// function add(){
//     count++;
//     return count;
// }


// function add(){
//     var count=0;
//     count++;
//     return count;
// }

// function add() {
//     var count = 0;
//     function plus(){
//           count += 1;
//     return count;
//     }
// }

//With Closure
var add=(function(){
    var count=0;
    return function(){
        count+=1;
        return count;
    }
}());