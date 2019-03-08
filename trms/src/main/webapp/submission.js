(function() {
	function toJSONString( form ) {
		var obj = {};
		var elements = form.querySelectorAll( "input, select" );
		for( var i = 0; i < elements.length; ++i ) {
			var element = elements[i];
			var name = element.name;
			var value = element.value;

			if( name ) {
				obj[ name ] = value;
			}
		}

		return JSON.stringify( obj );
	}

	document.addEventListener( "DOMContentLoaded", function() {
		var form = document.getElementById( "test" );
		var output = document.getElementById( "output" );
		form.addEventListener( "submit", function( e ) {
			e.preventDefault();
			var url = "/trms/form";
			var data = toJSONString( this );
			console.log(data);
			output.innerHTML = data;
			
			return fetch(url, {
			    method: "POST",
			    body: data
			})
			.then(function(res){ return res.json(); })
			.then(function(data){ alert( JSON.stringify( data ) ) })
			

		}, false);
		
	});

})();
