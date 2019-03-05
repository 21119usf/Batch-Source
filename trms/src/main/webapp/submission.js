function submitForm(){
    var submission = {
        fullName : document.getElementById("name").innerHTML,
        date : document.getElementById("startDate").innerHTML,
        startTime : document.getElementById("startTime").innerHTML,
        endTime : document.getElementById("endTime").innerHTML,
        location : document.getElementById("location").innerHTML,
        description : document.getElementById("description").innerHTML,
        cost : document.getElementById("cost").innerHTML,
        gradingFormat : document.getElementById("format").innerHTML,
        eventType : document.getElementById("type").innerHTML,
        supervisor : document.getElementById("supervisor").innerHTML,
        benCo : document.getElementById("benCo").innerHTML
    };
    
   // var myJSON = JSON.stringify(submission);
    //xmlhttp.open("GET", "form.html", true);
    alert("The form was submitted");
}

window.onload = function(){
	document.getElementById("submitButton").addEventListener("click", submitForm, false);
}