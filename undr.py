#!/usr/bin/python

import random
import time
import beepy

SLEEP = 2 * 60
SEED = 5

graph = {}


# put x over y
def put_on(x, y=None):
    l = graph.get(x)
    if not l:
        l = []
        graph[x] = l

    if y:
        l = graph.get(y)
        if not l:
            l = []
            graph[y] = l

        l.append(x)


put_on('pants')
put_on('trousers', 'pants')
put_on('belt', 'trousers')
put_on('pants')
put_on('left sock')
put_on('right sock')
put_on('left boot', 'left sock')
put_on('right boot', 'right sock')
put_on('left boot', 'trousers')
put_on('right boot', 'trousers')
put_on('t-shirt')
put_on('shirt', 't-shirt')
put_on('sweater', 'shirt')
put_on('curtca', 'sweater')
put_on('hat')
put_on('watches')

# random.seed(SEED)
while len(graph) > 0:
    time.sleep(SLEEP)

    may_take_off = [clothes for clothes, prevents in graph.items() if len(prevents) == 0]
    clothes_to_take_off = random.choice(may_take_off)
    del graph[clothes_to_take_off]
    for _, prevents in graph.items():
        if clothes_to_take_off in prevents:
            prevents.remove(clothes_to_take_off)

    print(clothes_to_take_off)
    beepy.beep(sound='ping')
    
input()
