var dataCounter = 1;

var dataContainer = document.getElementById("starwars");

var btn = document.getElementById("btn");

btn.addEventListener("click", function(){
    var pageRequest = new XMLHttpRequest();
    //                          swap for project url
    pageRequest.open('GET', 'https://swapi.co/api/species/');
    pageRequest.onload = function(){
        var theData = JSON.parse(pageRequest.responseText);
        // array of objects    
        var arr = theData.results
        // iterates through the array
        for (things of arr) {
            renderSpecies(things)
        }
    };
    pageRequest.send();
    dataCounter++;
    if (dataCounter > 3){
        console.log("uh-oh");
    }
});

// function renderHTML(data){
//     var htmlString = "";

//     for(i = 0; i < data.length; i++){
//         htmlString += "<p>"+ data[i].name + " is a " + data[i].species + ".</p>";
//     }

//     dataContainer.insertAdjacentHTML('beforeend', htmlString);

// }

//
function renderSpecies(species) {
    // root = getting the element that we will put all of our created elements into
    var root = document.getElementById("starwars")
    // the creation of the elements (in this case name and skin colors)
    var name = document.createElement("h5")
    name.textContent = "Name: " + species.name
    var skinColor = document.createElement("h5")
    skinColor.textContent = "species: " + species.skin_colors
    // this puts the elements into the root
    root.appendChild(name)
    root.appendChild(skinColor)
}
// for table, create table elements instead of headers