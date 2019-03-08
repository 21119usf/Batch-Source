var myPerson;

function RegisterServ(){
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		
		
		var emp_name = document.getElementById("name").value;
				
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var employee= JSON.parse(xhr.responseText);
			
			    
			//var person = JSON.parse(xhr.responseText);
			
			//myPerson = person;
		
			 /*person.name = document.getElementById("name").value;
				 document.getElementById("username").value = person.username;
				document.getElementById("password").value = person.password;
				document.getElementById("email").value = person.email;*/
				
				
			

				
				
				//stringify into JSON. emp_name, emp_username, emp_password, emp_email
				
				
				
				
				
				
				
				
				
				
			
		}
		
	}
	
	xhr.open("GET", "RegisterServ", true);
	xhr.send();
	
}

function postPerson(){
	
	var xhr = new XMLHttpRequest();
	
	var name = document.getElementById("name").value;
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var email = document.getElementById("email").value;
	
	var employeeObj = {name: name, username: username, password: password, email: email};
	var employeeJSON = JSON.stringify(employeeObj);
	console.log(employeeJSON);
	
	xhr.onreadystatechange= function(){
        console.log("Test onreadystatechange");
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            //var employee= JSON.parse(xhr.responseText);
           
        }
    }
	
	
	
	xhr.open("POST", "RegisterServ", true);
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

	xhr.send(employeeJSON);
	
}

console.log("in onload");
document.getElementById("empsubmit").addEventListener("click", postPerson, false);
//document.getElementById("myBtn2").addEventListener("click", postPerson, false);






































































/*
function getEmployee(){
    console.log("in getCharacter");
	//convert all of employee info input to JSON 
    var emp_name = document.getElementById("name").value;
	var emp_username = document.getElementById("username").value;
	var emp_password = document.getElementById("password").value;
	var emp_email = document.getElementById("email").value;
    

	
	
	//stringify into JSON. emp_name, emp_username, emp_password, emp_email
	var employeeObj = {name: emp_name, username: emp_username, password: emp_password, email: emp_email};
	var employeeJSON = JSON.stringify(employeeObj);
	console.log(employeeObj);
	console.log(employeeJSON);
	
    //Step 1
    var request= new XMLHttpRequest();
    //Step 2
    request.onreadystatechange= function(){
        console.log("Test onreadystatechange");
        if(request.readyState==4 && request.status==200){
            console.log(request.responseText);
            var employee= JSON.parse(request.responseText);
            loadEmployee(employee);
        }
    }
    //Step 3
	//stringify it in json
    request.open("POST","/RegisterServ"+employeeJSON,true);
    
    //Step 4
    request.send();
}


window.onload= function(){
    console.log("in onload");
    document.getElementById("empsubmit").addEventListener("click",getEmployee,false);
}
*/