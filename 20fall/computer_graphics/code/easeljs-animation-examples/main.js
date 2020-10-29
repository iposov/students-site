console.log("page loaded");

// создаем сцену, указываем id нашего canvas
let stage = new createjs.Stage("game");

// создадим таймер, который будет генерировать событие обновления сцены
// с нужной нам частотой (другими словами, нужным FPS)
createjs.Ticker.framerate = 20; // 20 раз в секунду будем перерисовывать экран
//алгоритм: RAF_SYNCHED = requestAnimationFrame + пропускает лишние срабатывания,
//чтобы срабатывало с нужной частотой. framerate = 20 значит будет пропускать каждый
//второй и третий кадр, т.к. обычно requestAnimationFrame это 60 кадров в секунду.
//RAF = requestAnimationFrame с его собственной частотой
//TIMEOUT = через setTimeout
createjs.Ticker.timingMode = createjs.Ticker.RAF_SYNCHED;
//добавляем событие. Сначала указыаем тип события. Эти типы перечислены в документации.
//tick - событие, что сработал таймер.
//Второй аргумент - действие для выполнения, в виде функции
//функция получает в качестве аргумента информацию о событии
//https://createjs.com/docs/easeljs/classes/Ticker.html#event_tick
/*
createjs.Ticker.addEventListener('tick', function(e) {
    console.log("сработал таймер " + e);
});
 */

//В easeljs в Ticker вместо функции пишут stage
//это особый случай, в этом случае вызывается stage.update(),
//т.е. рисование. Считайте, что это сокращение от function() { stage.update() }
createjs.Ticker.addEventListener('tick', stage);

//допустим, есть какой-то объект на сцене
let circle = new createjs.Shape();
circle.graphics //graphics это аналог ctx, на нем мы рисуем
    .beginFill("DeepSkyBlue") // аналог fillStyle
    .drawCircle(0, 0, 50); // аналог arc

stage.addChild(circle);

setInterval(function() {
    circle.x += 10;
    circle.y += 10;
}, 1000); //раз в секунду двигаю круг
//здесь нет ручного вызова stage.update() для перерисовки

//удобно с загрузкой картинок. Можно не ждать окончания загрузки, сцена
//все время перерисовывается, и картинка нарисуется сразу как загрузится.

//событие 'tick' есть не только у таймера, а у всех объектов на сцене
circle.addEventListener('tick', function(e) {
    circle.x += 10 * (e.delta / 1000); //скорость 10 пикселей в секунду
});

//событие tick срабатывает ровно тогда же, когда у таймера событие tick,
//на самом деле, срабатывает при перерисовке сцены stage.update()
//обработка этого событие - лучшее месте для анимации соответсвующего объекта.

//еще один тип display оbject - это спрайты.
var spriteSheet = new createjs.SpriteSheet({
    images: ["xira_final-spritesheet.png"],
    frames: {width:37, height:37},
    animations: {
        stand:[0, 3],
        run:[4, 12],
        jump:[13, 28, "run"] // run следующая анимация
    }
});
var sprite = new createjs.Sprite(spriteSheet);
stage.addChild(sprite); //добавить на сцену
sprite.x = 200;
sprite.y = 100;
sprite.gotoAndPlay("jump");

