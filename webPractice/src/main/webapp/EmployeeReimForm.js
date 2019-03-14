$('#sendInfo').click( function(e) {
    e.preventDefault();
    alert("go fuck yourself")
    var details =$('#form').serialize();
    //details.push($('#form').serialize());
    $.post('ServletWriter2',details, function(data){
        $('submitResponse').html(data);
    });
});