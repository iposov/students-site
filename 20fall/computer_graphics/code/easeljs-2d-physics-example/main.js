console.log("page loaded");

//2d физика.
//Box2D - написана на C++, популярна и переделана
//        на все языки.
//Для javascript: Matter.js, p2.js и т.д.
//Сейчас попробуем Matter.js

// создаем сцену, указываем id нашего canvas
let stage = new createjs.Stage("game");

// module aliases
var Engine = Matter.Engine,
    Render = Matter.Render,
    World = Matter.World,
    Bodies = Matter.Bodies;

// create an engine
var engine = Engine.create();

// create two boxes and a ground
var boxA = Bodies.rectangle(400, 200, 80, 80);
var boxB = Bodies.rectangle(450, 50, 80, 80);
var ground = Bodies.rectangle(400, 610, 810, 60, { isStatic: true });

// add all of the bodies to the world
World.add(engine.world, [boxA, boxB, ground]);

// run the engine
// Engine.run(engine);

// run the renderer
// Render.run(render);

createjs.Ticker.framerate = 60; // 20 раз в секунду будем перерисовывать экран
createjs.Ticker.timingMode = createjs.Ticker.RAF_SYNCHED;
createjs.Ticker.addEventListener('tick', stage);

// это два прямоугольника, которые будут падать:
let w = xPhys2xStage(80);
let h = yPhys2yStage(80);

let rect1 = new createjs.Shape();
rect1.graphics.beginFill("red").drawRect(0, 0, w, h);
let rect2 = new createjs.Shape();
rect2.graphics.beginFill("green").drawRect(0, 0, w, h);

stage.addChild(rect1);
stage.addChild(rect2);

stage.addEventListener('tick', function(e) {
    //Движок пересчитывает положение объектов. Ему надо периодически
    //сообщать, что прошло сколько-то времени.
    Engine.update(engine, e.delta / 3); // e.delta примерно 1000 / 60 мс
});

rect1.addEventListener('tick', function(e) {
    rect1.x = xPhys2xStage(boxA.position.x);
    rect1.y = yPhys2yStage(boxA.position.y);
});

rect2.addEventListener('tick', function(e) {
    rect2.x = xPhys2xStage(boxB.position.x);
    rect2.y = yPhys2yStage(boxB.position.y);
});

// системы координат
// физический мир x: 0 to 810, y: 0 to 670
// мир stage: x: 0 to 640 = canvas.width, y: 0 to 480 = canvas.height

function xPhys2xStage(x) { //2 это читается to
    return x / 810 * 640;
}

function yPhys2yStage(y) { //2 это читается to
    return y / 670 * 480;
}

//можно делать тела разной формы.
//можно назначать свойства - упругость, трение
//можно добавлять "ограничения". Например, говорим, что координата центра круга
//должна быть фиксированной.  Или говорим, что центр круга находится в определенной
//точке прямоугольника. Или можно привязывать к мыши.
//Можно делать разные виды ограничений, например, соединять точки двух тел пружиной.
//Т.е. мир состоит не только из тел, еще и из ограничений.

/*

1.

 */
