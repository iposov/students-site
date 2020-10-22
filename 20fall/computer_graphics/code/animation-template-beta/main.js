console.log("page loaded");

// подключение графики

let canvas = document.getElementById('game');
let ctx = canvas.getContext('2d'); //еще есть 'webgl'

/*
//setInterval, setTimeout, requestAnimationFrame

//вызывается с интервал в 1000 мс = 1 секунда
setInterval(function() {
    // console.log("oops " + new Date().getTime());
    console.log("oops");
}, 1000);

setTimeout(function() {
    console.log("bang");
    }, 5000
); //сделать ОДИН раз через пять секунд

requestAnimationFrame(function() {
    console.log("request animation frame был вызван");
}); // сделать действие в следующий раз, когда браузер занимается отрисовкой изображения

//можно так, но лучше вместо этого сделать requestAnimationFrame
setInterval(function() {
    x = x + 1;
    y = y + 1;
    draw();
}, 1000 / 30); //30 раз в секунду
 */

let x = 10; // координаты, положение прямоугольничка
let y = 10;

//рисование кадра
function draw() {
    //очистить весь canvas, это переменная введена в самом верху
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    ctx.fillStyle = "green";
    ctx.fillRect(x, y, 100, 100);
}

//функция, которая вызывается постоянно для очередного кадра
function tick() {
    x = x + 1;
    y = y + 1;
    draw();
    requestAnimationFrame(tick);
}

tick(); //вызвать функцию первый раз, далее она будет вызывать себя сама.

// обычно эта конструкция работает с частотой 60 кадров в секунду.
// Если хочется управлять количеством кадров в секунду, нужен код
// внутри tick который иногда пропускает рисование. Т.е. получится меньше,
// чем 60 рисований в секунду.
