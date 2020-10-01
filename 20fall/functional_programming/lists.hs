-- Операции со списками
-- Вспомним map и filter

expr1 = map (\x -> 2^x) [1..10]
expr2 = map (\s -> "a" ++ s) ["abc", "xyz"]
f1 :: Int -> Int
f1 x | x > 10 = 10
     | x > 0 = x
     | otherwise = 0
     
expr3 = map (\x -> f1 x) [-10..20] -- анонимная ф-ия, которая делает
                                   -- то же, что и f1
expr4 = map f1 [-10..20] -- но можно сразу f1 без анонимной функции

expr5 = filter (\x -> x > 0) [-10 .. 10]

-- concatMap еще одна функция, похожа на map
expr6 = map (\x -> [x, x + 1]) [10, 20, 30]
expr7 = concatMap (\x -> [x, x + 1]) [10, 20, 30]
expr8 = concatMap (\x -> if x > 0 then [x] else [x, x]) [-10, 20, -30]

-- foldl и foldr свертки. Тоже очень общие функции, через них можно 
-- реализовать другие, да и вообще много что можно сделать, потому
-- что они фактически заменяют циклы.

expr9  = foldl (\x y -> x + y) 0 [1..10]  -- сумма от 1 до 10
expr10 = foldr (\x y -> x + y) 0 [1..10]  -- сумма от 1 до 10

sum1 :: [Int] -> Int
sum1 list = foldl (\x y -> x + y) 0 list

-- пусть аккумулятор будет строкой
-- join записывает список через запятую
join :: [String] -> String
join list = foldl unite "" list where
                                 unite "" word = word
                                 unite a  word = a ++ ", " ++ word
                                 
-- было не очень эффективно. Приписывание новых слов трубет всё больше
-- времени, потому что a увеличивается.
-- можно ли сделать join без этой проблемы?

-- напишем foldl сами. foldr - упражнение.
foldl2 :: (a -> b -> a) -> a -> [b] -> a
foldl2 _ a [] = a
foldl2 op a (h:t) = foldl2 op (op a h) t -- хвостовая рекурсия!!

-- из-за хвостовой рекурсии foldl эффективней foldr.

--------------------------------------------------------
-- Тип данных tuples (тьюплы или кортежы)
t1 = ("abc", 42) -- в одной переменной сразу два значения. (String, Int)
t2 = (1, 2, [10, 20, 30]) -- три значения: (Int, Int, [Int])
-- отличие от списка: элементы могут иметь разные типы

-- примеры работы с tuple

add :: (Int, Int) -> Int
add (x, y) = x + y

-- вызов add (10, 20). Но не add 10 20 (один аргумент)

-- встроенные функции fst и snd:
fst1 :: (a, b) -> a
fst1 (x, _) = x   -- сопоставление с образцом

snd1 :: (a, b) -> b
snd1 (_, y) = y

-- Что если у нас есть список тьюплов:
-- [("a", 10), ("b", 20), ("c", 30)] :: [(String, Int)]
-- функция unzip
expr11 = unzip [("a", 10), ("b", 20), ("c", 30)]
-- результат (["a","b","c"],[10,20,30]) :: ([String], [Int])
-- наоборот
expr12 = zip [1..10] [21..30]
-- типы:
-- zip :: [a] -> [b] -> [(a, b)]
-- unzip :: [(a, b)] -> ([a], [b])

-- полезная мысль, в let и в where можно тоже делать
-- сопоставление с образцом.
sumFirstElements :: [(Int, a)] -> Int
-- sumFirstElement [(10, "a"), (20, "b"), (30, "c")] = 60
-- sumFirstElements list = sum (fst (unzip list))
-- sumFirstElements = sum . fst . unzip -- это анонс, поймем позже
sumFirstElements list = sum nums where
                                  (nums, _) = unzip list
                                  -- сопоставление с образцом !!

-- так же можно сопоставлять для списков: let h:t = [10, 20, 30]
-- h получится 10, t получится [20, 30]



repeat1 :: Int -> Char -> String 
repeat1 n char = helper n char "" where
                                    helper 0 char string = string
                                    helper n char string = helper (n-1) char (char:string)


