function testStuff() {
	console.log("inside testSTuff");
	var xhr = new SMLHttpRequest();
	xhr.onreadystatechange = function(){};
	xhr.oopen("GET", "demo", true);
	xhr.send();
}

function testStuff2() {
	console.log("inside testSTuff2");
	var xhr = new SMLHttpRequest();
	xhr.onreadystatechange = function(){};
	xhr.oopen("POST", "demo", true);
	xhr.send();
}

window.onload = function() {
	document.getElementById("myBtn").addEventListener("click", testStuff, false);
	document.getElementById("myBtn2").addEventListener("click", testStuff2, false);
}