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

    $("mybutton").click(function(event){
        event.preventDefault();
        var details = $("register").serialize();
        $.post("html2", details, function(data){
            $("change").html(data);
        });
    })
     
    var trows = document.getElementsByTagName("tr");
    trows[1].addEventListener("click",function(){calculate(100);
        trows[1].style.backgroundColor="rgb(10,10,10,.70)";
        for(var i=1;i<=6;i++){
            if(i!=1){
                trows[i].style.backgroundColor="#343a40";
            }
        };
    },false);

    trows[2].addEventListener("click",function(){calculate(90);
        trows[2].style.backgroundColor="rgb(10,10,10,.70)";
        for(var i=1;i<=6;i++){
            if(i!=2){
                trows[i].style.backgroundColor="#343a40";
            }
        };
       },false);
    trows[3].addEventListener("click",function(){calculate(80);
        trows[3].style.backgroundColor="rgb(10,10,10,.70)";
        for(var i=1;i<=6;i++){
            if(i!=3){
                trows[i].style.backgroundColor="#343a40";
            }
        };
       },false);
    trows[4].addEventListener("click",function(){calculate(75);
        trows[4].style.backgroundColor="rgb(10,10,10,.70)";
        for(var i=1;i<=6;i++){
            if(i!=4){
                trows[i].style.backgroundColor="#343a40";
            }
        };
       },false);
    trows[5].addEventListener("click",function(){calculate(60);
        trows[5].style.backgroundColor="rgb(10,10,10,.70)";
        for(var i=1;i<=6;i++){
            if(i!=5){
                trows[i].style.backgroundColor="#343a40";
            }
        };
       },false);
    trows[6].addEventListener("click",function(){calculate(30);
        trows[6].style.backgroundColor="rgb(10,10,10,.70)";
        for(var i=1;i<=6;i++){
            if(i!=6){
                trows[i].style.backgroundColor="#343a40";
            }
        };
       },false);


    function calculate(x){
        console.log("Hello");
        // var adjuster = document.getElementById('Adjuster').nodeValue;
        //var select = document.getElementById('choice').value;
    // console.log(select)
        var amountToReimbursement = 1000 - (1000*(x/100));

        document.getElementById("Cost").value = amountToReimbursement;
        console.log(amountToReimbursement);
    }
}


);
