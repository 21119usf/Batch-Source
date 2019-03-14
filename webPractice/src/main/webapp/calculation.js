

document.getElementById("calculate").addEventListener("click",function(event){
    event.preventDefault();
    calculate();
});

document.getElementById("approveBtn").addEventListener("click",function(event){
    event.preventDefault();
    overrideAmount();
});

function calculate(){
    
    // var adjuster = document.getElementById('Adjuster').nodeValue;
    var adjuster = document.forms["adjuster"]["adjusternum"].value;
    var amountToReimbursement = 0;

    amountToReimbursement = 1000 - (1000*(adjuster/100));

    document.getElementById("calculatedAmount").innerHTML = amountToReimbursement;
}



function overrideAmount(){
    var override = document.forms["override"]["AmmountOverride"].value;
    alert(override);
}


// $("#calculate").click(function(e){
//     e.preventDefault();
//     var adjuster = $("#adjuster").serializeArray()[0].value;
//     document.forms.getElementById = adjuster;
//     document.forms["adjuster"]["adjusternum"].value = adjuster;
// })


$('#mybutton').click( function(e) {
    e.preventDefault();
    var details = $('#searchId').serialize();
    $.post('html2', details, function(data){
        $('#change').html(data);
    });
});