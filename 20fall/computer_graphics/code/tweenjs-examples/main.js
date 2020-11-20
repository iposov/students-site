console.log("page loaded");

// создаем сцену, указываем id нашего canvas
let stage = new createjs.Stage("game");

createjs.Ticker.framerate = 20; // 20 раз в секунду будем перерисовывать экран
createjs.Ticker.timingMode = createjs.Ticker.RAF_SYNCHED;
createjs.Ticker.addEventListener('tick', stage);

let circle = new createjs.Shape();
//Как сделать так, чтобы не просто ввести свойство, а заставить выполняться нужный
//нам код при изменении этого свойства. В Java было так: circle.setR() - это
//сеттер, set-метод.
//circle.r = 100; // так просто радиус не изменится, потому что никто не перерисует
// круг по-другому.
Object.defineProperty(circle, 'r', {
    set: function(newValue) {
        circle.rValue = newValue;

        //перерисовываем круг при изменении радиуса

        circle.graphics //graphics это аналог ctx, на нем мы рисуем
            .clear() //очистка содержимого фигуры
            .beginFill("DeepSkyBlue") // аналог fillStyle
            .drawCircle(0, 0, circle.r);
    },
    get: function() {
        return circle.rValue;
    }
});

circle.r = 50; // вводим свойство сами
stage.addChild(circle);

// createjs.Tween.get(circle) // будем создавать твин для круга
//     .wait(500)
//     .to({alpha:0, visible:false}, 1000)
//     .call(handleComplete);

let circleTween = createjs.Tween.get(circle);
circleTween.wait(3000); // 3 seconds
circleTween.to({x: 100, y: 200}, 3000);
circleTween.to({r: 200}, 3000);
circleTween.to({x: 300}, 3000);
circleTween.call(function() {
    console.log("x стало равно 300");
});
circleTween.to({y: 100}, 3000);
circleTween.to({alpha: 0.1}, 3000);

//circle.alpha = 0.8
//circle.x = 300

// еще одна фигура, прямоугольник, будет запущен параллельно

let rect = new createjs.Shape();
rect.graphics
    .beginFill("red")
    .drawRect(0, 0, 20, 40);
rect.x = 100;
rect.y = 200;

createjs.Tween.get(square)
    .to({x: 300}, 3000, createjs.Ease.bounceInOut);
     //circIn это функция, но здесь мы указываем
     //ее без аргументов. Аргументы передаст Твин

stage.addChild(square);
