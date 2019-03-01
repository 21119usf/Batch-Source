window.onload = function()
{
	document.getElementById("submit").addEventListener("click",getCharacter,true);
};

function loadCharacter(character)
{
    document.getElementById("name").innerHTML=character.name;
	document.getElementById("gender").innerHTML = character.gender;
	document.getElementById("homeworld").innerHTML = character.homeworld;
	document.getElementById("birthyear").innerHTML = character.birth_year;
	document.getElementById("haircolor").innerHTML = character.hair_color;
	document.getElementById("eyecolor").innerHTML = character.eye_color;
}

function getCharacter()
{
	console.log("in getCharacter");
    var characterID = document.getElementById("swID").value;
    //Step 1
    var xhr= new XMLHttpRequest();
    //Step 2
    xhr.onreadystatechange= function()
	{
        console.log("Roll Tide");
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var character= JSON.parse(xhr.responseText);
            loadCharacter(character);
        }
	};
	xhr.open("GET","https://swapi.co/api/people/"+characterID,false);
    //Step 4
    xhr.send();
}