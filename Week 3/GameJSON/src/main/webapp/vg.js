window.onload=function(){
    console.log("in onload");
    document.getElementById("vgSubmitGet").addEventListener("click",getVG,false);
    //document.getElementById("vgpost").addEventListener("click",postVG,false);
}

function loadVG(vg){
    document.getElementById("vgName").innerHTML=vg.vgName;
}

function getVG(){
    console.log("in getVG");
    var vgid= document.getElementById("vgID").value;
    var xhr =new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC "+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var vg= JSON.parse(xhr.responseText);
            loadVG(vg);
        }
    }
  
    xhr.open("GET","http://localhost:8080/GameJSON/vg?vgid="+vgid,true);
    xhr.send();
}

function postVG(){

}







