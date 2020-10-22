```
a = [1, 2, 3]
Array(3) [ 1, 2, 3 ]

a[2]
3
a.push(40)
4
a
Array(4) [ 1, 2, 3, 40 ]

a.slice(1, 2)
Array [ 2 ]

// a[1:2]
undefined
a.slice(1)
Array(3) [ 2, 3, 40 ]

// a[1:]
undefined
a.slice() // копия
Array(4) [ 1, 2, 3, 40 ]

// a[:]
undefined
a.splice(2, 1, 31, 32, 33)
Array [ 3 ]

a
Array(6) [ 1, 2, 31, 32, 33, 40 ]

// splice изменила a
// с какого индекса удалить
// сколько удалить
// какие эл-ты вставить
undefined
o = {x: 1, y: 2, z: "abc"}
Object { x: 1, y: 2, z: "abc" }

//ввели объект o
undefined
o.x
1
o['x']
1
// второй вариант как в dict в python
undefined
// первый вариант как поле объекта
undefined
o.f = true
true
o
Object { x: 1, y: 2, z: "abc", f: true }

balls = [{x: 10, y: 20, vx: 5, vy: -5}, {x: 40, y: 50, vx: 10, vy: -5}]
(2) […]
​
0: Object { x: 10, y: 20, vx: 5, … }
​
1: Object { x: 40, y: 50, vx: 10, … }
​
length: 2
​
<prototype>: Array []

balls[0]
Object { x: 10, y: 20, vx: 5, vy: -5 }

balls[1]
Object { x: 40, y: 50, vx: 10, vy: -5 }

balls[0].x
10
// перебор элеметов массива
undefined
// в браузерном JS работает только перебор по индексу:
undefined
for (int i = 0; i < balls.length; i++)
Uncaught SyntaxError: missing ; after for-loop initializer debugger eval code:1:9
for (int i = 0; i < balls.length; i++)
    console.log(balls[i])
Uncaught SyntaxError: missing ; after for-loop initializer debugger eval code:1:9
for (let i = 0; i < balls.length; i++)
    console.log(balls[i])
Object { x: 10, y: 20, vx: 5, vy: -5 }
debugger eval code:2:10
Object { x: 40, y: 50, vx: 10, vy: -5 }
debugger eval code:2:10
undefined
for (let ball of balls)
  console.log(ball)
{…}
​
vx: 5
​
vy: -5
​
x: 10
​
y: 20
​
<prototype>: Object { … }
debugger eval code:2:11
Object { x: 40, y: 50, vx: 10, vy: -5 }
debugger eval code:2:11
undefined
// can i use: for-of узайте в каких браузерах работает
undefined

// a.forEach() -- см. сами

```
