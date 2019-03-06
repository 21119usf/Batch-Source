// JavaScript source code
window.onload=function(){
	document.getElementById("num1").onchange=sumOnChange;
	document.getElementById("num2").onchange=sumOnChange;
	document.getElementsByName("skills")[0].onchange=skillsOnChange;						//7
	var favoriteColor = document.getElementsByName("favoriteColor");						//8
	var i;
	for(i=0;i<favoriteColor.length;i++){
		favoriteColor[i].onchange=colorOnChange;
	}
	var emps = document.getElementsByClassName("empName");									//9
	for(i=0;i<emps.length;i++){
		emps[i].onmouseover=empOnMouseOver;
	}
	getCurrentTime();																		//10
	document.getElementById("helloWorld").addEventListener("click",delayRandomColor,true);	//11
	walkTheDOM(document, function (node){console.log(node.nodeName);});
}
//1. USA
function getUSA(){
	console.log(document.getElementsByTagName('h1')[0].childNodes[3].innerHTML);
}
//2. Sales
function getPeopleInSales(){
	var emps = document.getElementsByClassName('empName');
	var i;
	for(i=0;i<emps.length;i++){
		console.log(emps[i].innerHTML);
	}
}
//3. Click Here
function getAnchorChildren(){
	var spans = document.getElementsByTagName('span');
	var i;
	for(i=0;i<spans.length;i++){
		if(spans[i].parentNode.tagName == 'A'){
			console.log(spans[i].innerHTML);
		}
	}
}

//4. Hobbies
function getSkills(){
	var skillOpts = document.getElementsByName("skills")[0].childNodes;
	console.log(skillOpts);
	var i;
	for(i=0;i<skillOpts.length;i++){
		if(skillOpts[i].tagName == 'OPTION'){
			console.log("Value: "+skillOpts[i].value+" Contents: "+skillOpts[i].innerHTML);
		}
	}


}

//5. Customer Attribute
function getCustomAttribute(){
	var allElems = document.getElementsByTagName("*");
	var i;
	for(i=0;i<allElems.length;i++){
		if(allElems[i].hasAttribute("data-customAttr")){
			console.log("Element: "+allElems[i].tagName+" data-customAttr: "+allElems[i].getAttribute("data-customAttr"));
		}
	}
}

//6. Sum Event
function sumOnChange(e){
	var v1 = document.getElementById("num1").value;
	var v2 = document.getElementById("num2").value;
	var sum = document.getElementById("sum");
	if(!isNaN(v1) && !isNaN(v2)){
		document.getElementById("sum").innerHTML=(parseInt(v1)+parseInt(v2));
	}else{
		document.getElementById("sum").innerHTML=("Cannot Add");
	}
}

//7. Skills Event
function skillsOnChange(e){
	alert("Are you sure "+e.target.options[e.target.selectedIndex].value+" is one of your skills?");
}

//8. Favorite Color Event
function colorOnChange(e){
	console.log(e);
	alert("So you like "+e.target.value+" more than "+e.target.parentElement.style.backgroundColor);
	var favoriteColor = document.getElementsByName("favoriteColor");
	document.getElementById("firstForm").style.backgroundColor=e.target.value;
	
}


//9. Show/Hide Event
function empOnMouseOver(e){
	if(e.target.style.opacity == "0"){
		e.target.style.opacity = "1";
	}else{
		e.target.style.opacity = "0";
	}

}

//10. Current Time
function getCurrentTime(){
	var timeElem = document.getElementById("currentTime");
	var ampm = "AM";
	var date = new Date;
	var h = date.getHours();
	if(h>12){
		h=h-12;
		ampm="PM";
	}
	var m = date.getMinutes();
	if(m<10)m="0"+m;
	var s = date.getSeconds();
	if(s<10)s="0"+s;
	var s = h+":"+m+":"+s+" "+ampm;
	timeElem.innerHTML=s;
	setTimeout('getCurrentTime();','1000');
}

//11. Delay
function delayRandomColor(e){
	setTimeout(function(){
	e.target.style.color = '#'+(0x1000000+(Math.random())*0xffffff).toString(16).substr(1,6);
	},'3000');
}

//12. Walk the DOM
function walkTheDOM(node, func){
        func(node); 
        node = node.firstChild;
        while(node) {
            walkTheDOM(node,func);
            node = node.nextSibling;
        }
}