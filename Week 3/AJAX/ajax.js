function loadCharacter(character){
    document.getElelmentById("name").innerHTML=character.name;
}

function getCharacter(){
    console.log("in getCharacter");
    var username=document.getElementById("username").value;
    //Step 1
    var xhr= new XMLHttpRequest();
    //Step 2
    xhr.onreadystatechange = function(){
        console.log("UCF");
        if (xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var character = JSON.parse(xhr.responseText);
            loadCharacter(character);
        }
    }
    //Step 3
    xhr.open("GET","https://secure.runescape.com/m=hiscore_oldschool/index_lite.ws?player="+username,true);
    //Step 4
    xhr.send();
}
window.onload = function(){
    console.log("in onload");
    document.getElementById("Hiscore Submit").addEventListener("click",getCharacter,false);
}