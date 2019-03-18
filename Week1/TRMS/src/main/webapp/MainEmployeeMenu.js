// on load
$(function() {
//	setUpButtons();
});


$("#loginForm").submit(function(event) {
    /* stop form from submitting normally */
    event.preventDefault();

    /* get some values from elements on the page: */
    let username = $('#username').val();
    let password = $('#epass').val();

    // reset form
    $("#loginForm")[0].reset();
    
    // ajax call
    url = '/TRMS/login';
    data = {
    	username: username,
    	password: password
    }
    
    $.post(url, JSON.stringify(data), (data, status) => {
    	console.log(data);
        if(data === "Invalid Login")
        {
        	console.log(data);
        }
        else
        {
        	console.log("test");
        	window.location.href = "/TRMS/MainEmployeeMenu.html";	
        }
    });

    
});


//function setUpButtons() {
//	$('#a').click(function() {
//		console.log("test");
//	});
//}





























//var dataCounter = 1;
//
//var dataContainer = document.getElementById("starwars");
//
//$(document).ready(() => {
//	btn.addEventListener("click", function(event){
//		let username = getElementById("username");
//		let password = getElementById("epass");
//		let body = {username, password}
//		event.preventDefault()
//	    var pageRequest = new XMLHttpRequest();
//	    //swap for project url
//	    //pageRequest.open('POST', '/login');
//	    pageRequest.onload = function(){
//	        var theData = JSON.parse(pageRequest.responseText);
//	        sessionStorage.setItem("data", theData)
//	        window.location.href = "localhost:8080/TRMS/Reimbursement";
//	        // array of objects    
//	        var arr = theData.results
//	        // iterates through the array
//	        for (things of arr) {
//	            renderSpecies(things)
//	        }
//	    };
//	    pageRequest.send(body);
//	    dataCounter++;
//	    if (dataCounter > 3){
//	        console.log("uh-oh");
//	    }
//	});
//})
//var btn = document.getElementById("sub");
//console.log(btn)
//
//
//
//// function renderHTML(data){
////     var htmlString = "";
//
////     for(i = 0; i < data.length; i++){
////         htmlString += "<p>"+ data[i].name + " is a " + data[i].species + ".</p>";
////     }
//
////     dataContainer.insertAdjacentHTML('beforeend', htmlString);
//
//// }
//
////
//function renderSpecies(species) {
//    // root = getting the element that we will put all of our created elements into
//    var root = document.getElementById("starwars")
//    // the creation of the elements (in this case name and skin colors)
//    var name = document.createElement("h5")
//    name.textContent = "Name: " + species.name
//    var skinColor = document.createElement("h5")
//    skinColor.textContent = "species: " + species.skin_colors
//    // this puts the elements into the root
//    root.appendChild(name)
//    root.appendChild(skinColor)
//}
// for table, create table elements instead of headers