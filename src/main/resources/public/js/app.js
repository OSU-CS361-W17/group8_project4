var gameModel;

//This function will be called once the page is loaded.  It will get a new game model from the back end, and display it.
$(document).ready(function() {
    $("#frontButton1").click(function(){
        difficulty(1);
    });
    $("#frontButton2").click(function(){
        difficulty(2);
    });
    $.getJSON("model", function( json ) {
        displayGameState(json);
        gameModel = json;
    });
});



function difficulty(diffLevel) {
    $("div.modal").css("opacity", 0);
    setTimeout(function() {
        $("div.modal").css("display", "none");
    }, 1200);
    
    var urlStr;
    if (diffLevel == 1) {
        urlStr = "/difficulty/easy";
    }else{
        urlStr = "/difficulty/hard";
    }

    var request = $.ajax ({
        url: urlStr,
        method: "post",
        data: JSON.stringify(gameModel),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    });

    request.done(function(currModel) {
        displayGameState(currModel);
        gameModel = currModel;
    });

    // If there is a problem, and the bck does not respond, then diplay error. 
    request.fail(function(jqXHR, textStatus) {
        alert("Request failed: " + textStatus);
    });
}

function placeShip() {
    // This ajax call will asnychonously call the back end, and tell it where to place the ship, then get back a game model with the ship placed, and display the new model.
    var request = $.ajax({
        url: "/placeShip/"+$( "#shipSelec" ).val()+"/"+$( "#rowSelec" ).val()+"/"+$( "#colSelec" ).val()+"/"+$( "#orientationSelec" ).val(),
        method: "post",
        data: JSON.stringify(gameModel),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    });

    //This will be called when the call is returned from the server.
    request.done(function( currModel ) {
        displayGameState(currModel);
        gameModel = currModel;
    });

    // if there is a problem, and the back end does not respond, then an alert will be shown.
    request.fail(function( jqXHR, textStatus ) {
        alert( "Request failed: " + textStatus );
    });
}

//Similar to placeShip, but instead it will fire at a location the user selects.
function fire(){
    var request = $.ajax({
        url: "/fire/"+$( "#rowFire" ).val()+"/"+$( "#colFire" ).val(),
        method: "post",
        data: JSON.stringify(gameModel),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    });

    //This will be called when the call is returned from the server.
    request.done(function( currModel ) {
        displayGameState(currModel);
        gameModel = currModel;
    });

    // if there is a problem, and the back end does not respond, then an alert will be shown.
    request.fail(function( jqXHR, textStatus ) {
        alert( "Request failed: " + textStatus );
    });
}

// This function send request to scan enemy territory, and receive game state
function scan(){
    var request = $.ajax({
        url: "/scan/" + $("#rowScan").val() + "/" + $("#colScan").val(),
        method: "post",
        data: JSON.stringify(gameModel),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    });
    
    // This will be called when the call is returned from the server
    request.done(function(currModel){
        displayGameState(currModel);
        gameModel = currModel;
    });
    
    // If there is a problem, and the back end does not respond, then an alert will be shown.
    request.fail(function( jqXHR, textStatus ) {
        alert( "Request failed: " + textStatus );
    });
}
// This fucntion will set the difficulty of the game. 


//This function will display the game model.  It displays the ships on the users board, and then shows where there have been hits and misses on both boards.
function displayGameState(gameModel){
    
    console.log(gameModel);
    $( '#MyBoard td'  ).css("background-color", "blue");
    $( '#TheirBoard td'  ).css("background-color", "blue");

    displayShip(gameModel.aircraftCarrier);
    displayShip(gameModel.battleship);
    displayShip(gameModel.clipper);
    displayShip(gameModel.dinghy);
    displayShip(gameModel.submarine);
    
    for (var i = 0; i < gameModel.scanMisses.length; i++) {
        $("#TheirBoard #" + gameModel.scanMisses[i].row + "_" + gameModel.scanMisses[i].col).css("background-color", "teal");
    }
    for (var i = 0; i < gameModel.scanHits.length; i++) {
        $("#TheirBoard #" + gameModel.scanHits[i].row + "_" + gameModel.scanHits[i].col).css("background-color", "orange");
    }
    for (var i = 0; i < gameModel.computerMisses.length; i++) {
        $( '#MyBoard #' + gameModel.computerMisses[i].row + '_' + gameModel.computerMisses[i].col ).css("background-color", "green");
    }
    for (var i = 0; i < gameModel.computerHits.length; i++) {
        $( '#MyBoard #' + gameModel.computerHits[i].row + '_' + gameModel.computerHits[i].col ).css("background-color", "red");
    }

    for (var i = 0; i < gameModel.playerMisses.length; i++) {
        $( '#TheirBoard #' + gameModel.playerMisses[i].row + '_' + gameModel.playerMisses[i].col ).css("background-color", "green");
    }
    for (var i = 0; i < gameModel.playerHits.length; i++) {
        $( '#TheirBoard #' + gameModel.playerHits[i].row + '_' + gameModel.playerHits[i].col ).css("background-color", "red");
    }
}


//This function will display a ship given a ship object in JSON
function displayShip(ship){
    startCoordRow = ship.start.row;
    startCoordCol = ship.start.col;
    endCoordRow = ship.end.row;
    endCoordCol = ship.end.col;
    if(startCoordRow > 0){
        if(startCoordRow == endCoordRow){
            for (i = startCoordCol; i <= endCoordCol; i++) {
                $( '#MyBoard #'+startCoordRow+'_'+i  ).css("background-color", "yellow");
            }
        } else {
            for (i = startCoordRow; i <= endCoordRow; i++) {
                $( '#MyBoard #'+i+'_'+startCoordCol  ).css("background-color", "yellow");
            }
        }
    }
}
