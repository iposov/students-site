console.log("page loaded");

// создаем сцену, указываем id нашего canvas
let stage = new createjs.Stage("game");

// для рисования мы добавляем на сцену объекты
// - Shape, фигуры, это рисунки в стиле canvas: линии, круги,
// прямоугольники и т.п.
// - Bitmap картинка
// - Sprite анимированная картинка, можно настраивать ей
// набор кадров, менять его
// - контейнеры, могут содержать другие объекты и контейнеры.
// Например, контейнер для фона: несколько картинок

// У каждого объекта есть координаты, трансформации типа
// поворотов и растяжений. Есть события мыши для каждого объекта
// Есть фильтры типа цветовых.

//фигурка, можно рисовать как на Canvas
let circle = new createjs.Shape();

circle.graphics //graphics это аналог ctx, на нем мы рисуем
    .beginFill("DeepSkyBlue") // аналог fillStyle
    .drawCircle(0, 0, 50); // аналог arc

// координаты указали
circle.x = 100;
circle.y = 100;

circle.regX = 10;
circle.regY = 20;

// добавили на сцену, это значит, что теперь сцене
// есть, что показывать
stage.addChild(circle);

// обязательно вызываем update, только после update
// что-то рисуется.
stage.update();

// кроме shape есть Bitmap, загруженная картинка
let cat = new createjs.Bitmap("cat.png");
// начало координат слева сверху
// regX и regY = 0 по умолчанию
cat.x = 200; //поэтому это координаты левого
cat.y = 100; //верхнего угла рисунка

stage.addChild(cat); //обязательно добавить на сцену,
                //иначе объект невидим

//загрузка происходит не сразу, поэтому пока
//не видим
stage.update();

//скоро будет анимация, когда stage.update()
//вызывается автоматически несколько раз в секунду
//тогда картинка покажется, как только загрузится.

// Sprite - еще один объект, который можно
// класть на сцену. У него есть SpriteSheet
// это набор картинок, и мы можем
// указывать, в каком порядке картинки менять.

// Еще один тип объектов для отображения - это
// контейнер

let c = new createjs.Container();

let cat1 = new createjs.Bitmap("cat.png");
let cat2 = new createjs.Bitmap("cat.png");

c.addChild(cat1);
c.addChild(cat2);

cat1.x = 0;
cat1.y = 0;
cat2.x = 75;
cat2.y = 0;

// cat1.rotation = 2; поворот внутри контейнера.

stage.addChild(c);

c.x = 200;
c.y = 200;
c.regX = 75;
c.regY = 0;
//поворот вокруг regX, regY.
//эти же значения regX, regY указывают,
//для какой точки заданы координаты 200, 200
c.rotation = 60;
c.alpha = 0.4; //80% непрозрачности
c.scaleX = 2;
c.scaleY = 2;

setTimeout(function() {
    stage.update(); //нарисовать через 3 секунды
}, 2000);

/*
Shape, Sprite, Bitmap, Container -
это DisplayObject, т.е. объекты, которые
можно класть на сцену для отображения.
stage -
      circle (Shape)
      cat (Bitmap)
      c (Container) -
            cat1 (Bitmap)
            cat2 (Bitmap)
 */
