console.log("page loaded");

// создаем сцену, указываем id нашего canvas
let stage = new createjs.Stage("game");

createjs.Ticker.framerate = 20; // 20 раз в секунду будем перерисовывать экран
createjs.Ticker.timingMode = createjs.Ticker.RAF_SYNCHED;
createjs.Ticker.addEventListener('tick', stage);

let circle = new createjs.Shape();
circle.graphics //graphics это аналог ctx, на нем мы рисуем
    .beginFill("DeepSkyBlue") // аналог fillStyle
    .drawCircle(0, 0, 50);
stage.addChild(circle);

// кнопка

let button = new createjs.Container();
stage.addChild(button);

// фон кнопки

let bg = new createjs.Shape();
bg.graphics
    .beginFill("#FF8800")
    .drawRect(0, 0, 100, 60);

button.addChild(bg);

// теперь текст на кнопке
var text = new createjs.Text("Нажми", "bold 28px Arial", "#1100ff");
text.x = 50; // центр кнопки
text.y = 30;
text.textBaseline = "middle";
text.textAlign = "center";

button.addChild(text);

// положение дисплей-объектов на сцене

circle.x = 100;
circle.y = 100;

button.x = 250;
button.y = 100;

// обработка событий
circle.addEventListener("click", function(e) {
    //е имеет тип MouseEvent
    console.log("Нажали на круг", e.localX, e.localY, e.stageX, e.stageY);
}); // клик мыши, или нажатие пальцем

/*
мы пишем анонимную функцию как обработчик события. Обычно этого достаточно, иногда
обработчик пишут отдельно:
function handleClick(e) {
    //обработка нажатия
}
circle.addEventListener("click", handleClick); //не handleClick()
//тогда можно удалить при необходимости обработчик
circle.removeEventListener("click", handleClick);
 */

// обработка событий
button.addEventListener("click", function(e) {
    //е имеет тип MouseEvent
    console.log("Нажали на кнопку", e.localX, e.localY, e.stageX, e.stageY);
}); // клик мыши, или нажатие пальцем

bg.addEventListener("click", function(e) {
    //е имеет тип MouseEvent
    console.log("Нажали на фон кнопки", e.localX, e.localY, e.stageX, e.stageY);
}); // клик мыши, или нажатие пальцем

text.addEventListener("click", function(e) {
    //е имеет тип MouseEvent
    console.log("Нажали на текст кнопки", e.localX, e.localY, e.stageX, e.stageY);
}); // клик мыши, или нажатие пальцем

// еще события мыши кроме click
// "mousedown" - опустили кнопку мыши. Это первая часть события click
// само событие click произойдет только после того, как кнопку мыши отпустят

//два события: указатель мышь попал на объект и ушел с объекта
circle.addEventListener("mouseover", function(e) {
    console.log("мышь наведена на круг", e.localX, e.localY);
});
circle.addEventListener("mouseout", function(e) {
    console.log("мышь уведена с круга");
});

stage.enableMouseOver(); //обязательно включить эти события

//еще два очень похожих события rollover, rollout:
button.addEventListener("mouseover", function(e) {
    console.log("мышь наведена на кнопку mouseover", e.localX, e.localY);
});
button.addEventListener("mouseout", function(e) {
    console.log("мышь уведена с кнопки mouseout");
});
button.addEventListener("rollover", function(e) {
    console.log("мышь наведена на кнопку rollover", e.localX, e.localY);
});
button.addEventListener("rollout", function(e) {
    console.log("мышь уведена с кнопки rollout");
});

//rollover и rollout - это то, чем реально надо пользоваться. Оно работает
//так, как логично.
//mouseover это обычное событие, оно срабатывает для всех объектов кнопки:
// для текста, для фона. Но, вспомните событие click, оно срабатывает сначала
// для текста, потом срабатывает на кнопку. mouseover аналогично. Срабатывает сначала
// для текста, потом для кнопки. Но второе срабатывание для кнопки нас удивляет.
// мы же не навели мышь на кнопку.

// посмотрите отдельно события мыши для stage, их больше
// https://createjs.com/docs/easeljs/classes/Stage.html
// там есть stagemousemove — срабатывает при любом движении мыши
// есть mouseenter - срабатывает, когда мышь наводится на canvas
// Просто rollover для сцены работает только при наведении мыши на один из
// объектов сцены.

// событие pressmove у дисплей объектов может быть удобно, если вы хотите
// перетаскивать объект. Оно срабатывает, когда вы двигаете мышь с нажатой
// кнопкой.

// Порядок распространения события
// В каком порядке события срабатывают в контейнере.
//
// сцена <- кнопка <- фон
//
// допустим, мы нажали на фон, в каком порядке происходит событие click.
// И другие события тоже
//
// 1) click для сцены в фазе capture (захват)
// 2) click для кнопки в фазе capture (захват)
// 3) click для фона в фазе capture (захват)
// 4) click для фона в фазе bubbling (всплытие)
// 5) click для кнопки в фазе bubbling (всплытие)
// 6) click для сцены в фазе bubbling (всплытие)
stage.addEventListener("click", function (e) {
    console.warn("СЦЕНА CAPTURE", e.target.NAME, e.currentTarget.NAME);
}, true);
bg.addEventListener("click", function (e) {
    console.warn("ФОН CAPTURE", e.target.NAME, e.currentTarget.NAME);
}, true);
button.addEventListener("click", function (e) {
    console.warn("КНОПКА CAPTURE", e.target.NAME, e.currentTarget.NAME);
}, true);
button.addEventListener("click", function (e) {
    console.warn("КНОПКА BUBBLING", e.target.NAME, e.currentTarget.NAME);
}, false);
bg.addEventListener("click", function (e) {
    console.warn("ФОН BUBBLING", e.target.NAME, e.currentTarget.NAME);
}, false);
stage.addEventListener("click", function (e) {
    console.warn("СЦЕНА BUBBLING", e.target.NAME, e.currentTarget.NAME);
    //здесь currentTarget всегда stage
}, false);

// e.target - это то, на что реально нажали. Когда для сцены срабатывает событие
// click, все равно через target мы можем узнать, на объект реально нажали.
// e.currentTarget - это то, для кого обрабатывается событие.

button.NAME = "кнопка";
bg.NAME = "фон";
stage.NAME = "сцена";
