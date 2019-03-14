$('#mybutton').click( function(e) {
    e.preventDefault();
    var details = $('#register').serialize();
    $.post('CheckStatus', details, function(data){
        $('#change').html(data);
    });
});