console.log("page loaded");

// как нарисовать хоть что-нибудь
// без jquery
let canvas = document.getElementById('game');
// ctx - контекст для рисования, все действия только с ним
let ctx = canvas.getContext('2d'); //еще есть 'webgl'

function draw() {
    ctx.save(); // сохранить состояние контекста. Координаты, ширины линий, цвета
                // и очень много всего другого

    ctx.fillStyle = "green"; // как в css
    ctx.fillRect(10, 10, 100, 100);

    ctx.strokeStyle = 'rgb(100, 50, 50)';
    ctx.strokeRect(50.5, 50.5, 100, 150);

    ctx.beginPath(); // начинаем задавать контур (пока не рисовать!)
    ctx.moveTo(100, 100); //двигаем карандашик для контура в точку
    ctx.lineTo(200, 100);
    ctx.lineTo(200, 150);

    ctx.strokeStyle = 'black';
    ctx.lineWidth = 4;
    ctx.stroke(); // нарисовать по контуру цветом strokeStyle
    ctx.fill(); // закрашивает. При необходимости контур закрывается - проводится линия в начало
    ctx.closePath(); // явная команда провести в контуре линию в начало

    ctx.restore(); // восстановить все данные, которые были сохранены в save()
    // restore и save должны ходить парами.
}

function draw_coord_system() {
    ctx.save(); // save - restore в любой ф-ии, которая меняет контекст ctx

    ctx.strokeStyle = 'green';
    ctx.lineWidth = 2;
    ctx.strokeRect(-4, -4, 8, 8); //прямоугольник с центром в 0

    ctx.beginPath();
    ctx.strokeStyle = 'blue';
    ctx.moveTo(0, 0);
    ctx.lineTo(100, 0);
    ctx.stroke();

    ctx.beginPath();
    ctx.strokeStyle = 'red';
    ctx.moveTo(0, 0);
    ctx.lineTo(0, 100);
    ctx.stroke();

    ctx.restore();
}

draw();
draw_coord_system();

ctx.translate(100, 230); //сместить систему координат в точку 100, 230
draw();
draw_coord_system();

ctx.translate(10, 10);
draw();
draw_coord_system();

ctx.rotate(10 * Math.PI / 180);
draw();
draw_coord_system();

ctx.translate(250, 0);
draw();
draw_coord_system();

ctx.scale(0.33, 3); //сжать в 3 раза по x, растянуть по y
draw();
draw_coord_system();

// попробуйте в задаче про шарики в самом начале, сразу после ctx = ..
// ctx.rotate(10 * Math.PI / 180)

// подумайте, как повернуть систему координат относительно точки 100, 100. А не 0, 0
// для этого нужно сделать несколько rotate и translate.

// принцип. При рисовании отдельных объектов: герой, домик. Рисуйте в естественной
// для объекта системе кординат. Перед рисованием объекта делайте translate
// в ту точку, где он должен быть нарисован.
