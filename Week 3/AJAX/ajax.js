function loadCharacter(character){
    document.getElementById("name").innerHTML=character.name;
}
function getCharacter(){
    console.log("in getCharacter");
    var characterID = document.getElementById("swID").value;
    
    //Step 1
    var xhr= new XMLHttpRequest();
    //Step 2
    xhr.onreadystatechange= function(){
        console.log("Roll Tide");
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var character= JSON.parse(xhr.responseText);
            loadCharacter(character);
        }
    }
    //Step 3
    xhr.open("GET","https://swapi.co/api/people/"+characterID,true);
    //Step 4
    xhr.send();
}
window.onload= function(){
    console.log("in onload");
    document.getElementById("starwarssubmit").addEventListener("click",getCharacter,false);
}