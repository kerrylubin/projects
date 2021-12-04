//first thing is to make a konva Stage
var stage = new Konva.Stage({
    container : '#stage',
    width: 500,
    height: 500,
});



// Then a Layer1

var layer = new Konva.Layer({

});


//then Shape1
var circle =new Konva.Circle({
    x: 250,
    y: 250,
    radius: 50,
    fill: 'green'
});





//Then add a shape to layer one
layer.add(circle);


//then add layer to Stage
stage.add(layer);