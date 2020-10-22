console.log("page loaded");

// подключение графики

let canvas = document.getElementById('game');
let ctx = canvas.getContext('2d'); //еще есть 'webgl'

function currentTime() {
    return new Date().getTime(); //getTime = кол-во мс с 1 января 1970
}

let animationStart = currentTime(); //время начала всей анимации
let lastFrameTime = currentTime(); //время рисования последнего кадра

// доступ к картинкам
let img1 = document.getElementById('a-cat');
let img2 = new Image(); //Image соответствует <img>
img2.src = 'cover-small_file.png';

//img1 - это уже загруженная картинка. См HTML
//img2 загрузится не сразу. Узнать, когда он загружен можно так
img2.onload = function() {
    console.log("img2 loaded");
};

// меняющаяся часть шаблона. Здесь задаем начальные данные о нашем мире
const BALL_XO = 0; // левый верхний угол первого спрайта
const BALL_Y0 = 50;
const SPRITE_W = 50; // размеры спрайта
const SPRITE_H = 50;
const SPRITES_COUNT = 10;
const FPS = 10; //20 кадров в секунду

let spriteIndex = 0;

let spriteSheet = new Image();
spriteSheet.src = 'balls.png';

//рисование кадра. Нужно заменить на своё.
function draw() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    // рисование изображения
    ctx.drawImage(img1, 100, 100);
    ctx.drawImage(img2, 200, 100);
    // сами: другие варианты drawImagе. Можно указать не только, где рисовать,
    // но и какого размера нарисовать.
    // Еще можно тем же drawImage нарисовать только часть картинки

    // нарисовать спрайт с номером spriteIndex
    ctx.drawImage(
        spriteSheet,
        BALL_XO + spriteIndex * SPRITE_W, BALL_Y0, // положение выреза на исходном изображении
        SPRITE_W, SPRITE_H, // высота и ширина выреза
        300, 200, // где рисовать на canvas
        SPRITE_W, SPRITE_H // размер рисуемого изображения
    );
}

//функция изменяет состояние мира. Нужно заменить на свою
//аргументы: время, прошедшее с начала анимации в мс
//время, прошедшее с прошлого кадра в мс
function step(timeFromAnimationStart, timeFromLastFrame) {
    // вычисляем номер кадра в зависимости от того, сколько прошло времени
    spriteIndex = Math.floor(timeFromAnimationStart / (1000 / FPS)) % SPRITES_COUNT;
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
