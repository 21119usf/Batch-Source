
 $('#sendInfo').click( function(e) {
    e.preventDefault();
    var details = $('#pushInfo').serialize();
    $.post('ServletWriter2', details, function(data){
        document.getElementById('change2').innerHTML=data;
        // $('popup').click();
        console.log(data);
    });
});

$('#getNewForm').click( function(e) {
    e.preventDefault();
    $('#formInfo').load('EmployeeReimForm.html .row').hide().fadeIn('slow');
    document.getElementById('sendInfo').style.display="block";
});

$(document).ready(function(){
    document.getElementById("choice").addEventListener("change",calculate, false);
    console.log("aaaaaa")

    function calculate(){
        console.log("Hello");
        // var adjuster = document.getElementById('Adjuster').nodeValue;
        var select = document.getElementById('choice').value;
        console.log(select)
        var amountToReimbursement = 1000 - (1000*(select/100));
    
        document.getElementById("h").value = amountToReimbursement;
        console.log("asdasd")
        
    }
    
    
    
    // function overrideAmount(){
    //     var override = document.forms["override"]["AmmountOverride"].value;
    //     alert(override);
    // }
})
