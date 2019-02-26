//JavaScript is NOT related to java
//not compiled- interpreted
//Loosely typed- variable type are assigned at runtime
var a=10;
console.log(a);
a="chaos";
console.log(a);
var b,c,d,e,f,g,h,e;
b="10";
c=true;
d={};
e=null;
g=(0/0);
h=[];
i=function(){};
//datatypes
//-numbers -- 64bit floating point: ONLY accurate to powers of 2
//-string -- 0 or more characters; no character type, '' or ""
//-.length method
//-objects -- key value pairs
//-undefined -- declared but no info on what it should be
//-null
//-Not a Number -- NaN
//-symbol -- a variable type in Java
//-boolean -- true, false, truthy and falsy
//truthy: everything true and everything not falsy; can be an object
//falsy: 0, undefined, null, false, "", NaN

//Type Coercion
console.log(5==5);//true
console.log(5=="5"); //also true
//comparing values, not types
// console.log(5==="5"); //strict comparator, going to be false
// console.log("Tests:");
// console.log(false==1);//false
// console.log(false==0);//true
// console.log(true==1);//true
// console.log(true==12);//false
// console.log(false==-1);//false

console.log(7+7+7);//21
console.log(7+7+'7');//147
console.log('7' + 7+7);//777

//Objects in JS
//collections of property-value pairs
//Object Literal
var person = {
    "name": "Jimmy",
    "age":92

};

person.numOfFeet=2;
//Constructor
function Human(name,age){
    this.name=name;
    this.age=age;
}

var bill = new Human("Bill", 51);
//Marker function
function makeHuman(name,age){
    var h={};
    h.name=name;
    h.age=age;
    return h;
}
//Another marker function
function makeHuman2(name,age){
    var p = {
        "name":name,
        "age":age
    }
    return p;
}

//Arrays
//inherit from object
var arr=[10,20,30];
arr[9]=5;//the middle ones are undefined
arr[1000]="Boo";
arr[4]=makeHuman("Kevin",14);

//Functions
//object type in JS
//function form -- "this" referes to global object. 
//In browser, it is the window
function dividebyzero(kitty,cat){
    console.log("hey kitty cat");
    return (kitty + cat)
}
//constructor form -- "this" refers to the object being created
var conFunction = new function(a,b) {
return a*b
}
//method form -- "this" refers to person
person.getInfo = function(){
    return this.age;
}

crazy = function(at,least,three){
    console.log(at);
    console.log(least);
    console.log(three);
    console.log(arguments[5]);
}

//scopes
//Function scope
//thins that are declared inside a function
//####use the "var" keyword####
//If you leave out var, you'll create an implicit global
//accessible only inside function
//Global Scope
//declared outside of any function. Accessible anywhere
//the one that was declared the most recently. 
//Variable name clashes are bad. Difficult to debug and test
//"let" does not escape blocks, "var" does
//Hoisting - moves the declaration to top of scope
//shadowing - if multiple variabls have the same name, JS will use
//WATCH OUT!!
//Implicit globals - variables declared in functional scope wihout 
//the var keyword, unless you're in strict mode
//Generally, stay away from using globals.

//Closure
//Inner function that has access to an outer function's variables (scope chain)
//simulates private variables
//has 3 scope chains
//1. it has access to its own scope (variables defined between its curly braces)
//2. it has access to the outer function's variables
//3. it has access to the global variables
//closure mimics encapsulation

//Build a reusable counter
// var count = 0;
// function add(){
//     count++;
//     return count;
// }//^-NOT secure
// function add(){
//     var count = 0;
//     count++;
//     return count;
// }
// function add(){
//     var count = 0;
//     function plus(){
//     count++;
//     return count;
//     }
// }
//Now utilizing closure:
var add = (function(){
    var count = 0;
    return function(){
        count+=1;
        return count;
    }
}());




