
$('#mybutton').click( function(e) {
    e.preventDefault();
    var details = $('#register').serialize();
    $.post('html2', details, function(data){
        $('#change').html(data);
    });
});