console.log("page loaded");

// подключение графики

let canvas = document.getElementById('game');
let ctx = canvas.getContext('2d'); //еще есть 'webgl'

function currentTime() {
    return new Date().getTime(); //getTime = кол-во мс с 1 января 1970
}

let animationStart = currentTime(); //время начала всей анимации
let lastFrameTime = currentTime(); //время рисования последнего кадра

// меняющаяся часть шаблона. Здесь задаем начальные данные о нашем мире
const SPEED = 200; //20 пикселей в секунду
let x = 10; // координаты, положение прямоугольничка
let y = 10;

//рисование кадра. Нужно заменить на своё.
function draw() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    ctx.fillStyle = "green";
    ctx.fillRect(x, y, 100, 100);
}

//функция изменяет состояние мира. Нужно заменить на свою
//аргументы: время, прошедшее с начала анимации в мс
//время, прошедшее с прошлого кадра в мс
function step(timeFromAnimationStart, timeFromLastFrame) {
    // расстояние = скорость * время
    x = x + SPEED * (timeFromLastFrame / 1000); // делим на 1000, переводим мс в сек
    y = y + SPEED * (timeFromLastFrame / 1000);
}

//функция, которая вызывается постоянно для очередного кадра.
//Теперь tick универсален. Он всегда будет такой.
function tick() {
    let now = currentTime();
    let timeFromAnimationStart = now - animationStart;
    let timeFromLastFrame = now - lastFrameTime;
    lastFrameTime = now;

    step(timeFromAnimationStart, timeFromLastFrame);
    draw();
    requestAnimationFrame(tick);
}

tick(); //вызвать функцию первый раз, далее она будет вызывать себя сама.

// обычно эта конструкция работает с частотой 60 кадров в секунду.
// Если хочется управлять количеством кадров в секунду, нужен код
// внутри tick который иногда пропускает рисование. Т.е. получится меньше,
// чем 60 рисований в секунду.
