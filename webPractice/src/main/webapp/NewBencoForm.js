$('#getNewForm').click( function(e) {
    e.preventDefault();
    var details =$('#form').serialize();
    $.post('EmployeeReimForm',details, function(data){
        $('#formInfo').html(data);
    });
});