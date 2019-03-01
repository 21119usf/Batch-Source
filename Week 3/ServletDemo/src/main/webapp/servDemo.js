function testStuff (){
	console.log("inside test stuff");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange=function(){};
	xhr.open("GET","demo",true);
	xhr.send();
}
function testStuff2 (){
	console.log("inside test stuff2");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange=function(){};
	xhr.open("POST","demo",true);
	xhr.send();
}
window.onload=function(){
	document.getElementById("myBtn").addEventListener("click",testStuff,false);
	document.getElementById("myBtn2").addEventListener("click",testStuff2,false);
	
}