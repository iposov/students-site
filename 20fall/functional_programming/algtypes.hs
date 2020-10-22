-- Алгебраические типы данных

-- data ключевое слово для описания алгебраического типа
-- Person - это новый тип, описывает людей
-- Значения могут быть одного из двух видов: Student или Lecturer
-- про стедентов хранится дополнительная информация о их имени (тип
-- String) и об их курсе (тип Int).
-- Про препоподавателя хранится только имя (String)
-- Lecturer и Student - это **конструкторы типа**
-- deriving Show это заклинание, чтобы можно было распечатывать
-- значения типа Person
data Person = Student String Int | Lecturer String deriving Show

-- для создания значений типа пользуемся конструкторами типа
-- конструктор типа это функция, которая получает дополнительные
-- данные и создает значение.
-- Student :: String -> Int -> Person
-- Lecturer :: String -> Person
person1 = Student "Ilya" 4
person2 = Lecturer "John"

-- давайте сделаем функцию, которая возвращает имя человека.
-- используем сопоставление с образцом
getName :: Person -> String
getName (Student name _) = name -- если аргумент это студент
getName (Lecturer name) = name -- если аргумент это преподаватель

-- getName person1 должно получиться Ilya

getCourse :: Person -> Int
getCourse (Student _ course) = course

-- другой пример, многочлен с целыми коэффициентами
data Polynomial = Polynomial [Int] deriving Show
-- Polynomial первый - это название типа.
-- Polynomial второй - это конструктор типа.
-- тип и конструктор типа могут называться одинаково. Так часто бывает,
-- в коде всегда понятно, что имеется в виду, тип или конструктор

poly1 = Polynomial [1, 2, 3] -- 1x^2 + 2x + 3

sumCoefs :: Polynomial -> Int -- здесь Polynomial это тип
sumCoefs (Polynomial l) = sum l -- здесь Polynomial это конструктор

-- проверка, что старший коээфициент равен 1
is1 :: Polynomial -> Bool
is1 (Polynomial (1:_)) = True
is1 _ = False

is1' :: Polynomial -> Bool
is1' (Polynomial (h:_)) = h == 1

-- другие примеры
-- data Bool :: True | False 
-- кстати, списки тоже алгебраические типы. Только
-- у них немного необычный синтаксис. Но и обычный поддержиывается.
-- для примера список Int
data ListInt = Empty | Cons Int ListInt deriving Show
-- 3 `Cons` Empty сравните с 3 : []
-- 1 `Cons` (2 `Cons` (3 `Cons` Empty)) или 1 : (2 : (3 : []))
--list :: [Int]
list :: [] Int -- т.е. имя типа а потом Int
list = [10, 20, 30]

-- Итого, обычный список определен так:
-- data [] a = [] | a : ([] a)

-- Мы сейчас увидели, что алгебраический тип может быть параметризован
data Pair a = Pair a a deriving Show
-- это тип для хранения двух значений типа a. Пара значений
-- сравните с data Pair = Pair Int Int. Но в такой версии можно было бы
-- хранить только пару Int
x1 = Pair 42 12   -- x1 :: Pair Int
x2 = Pair "abc" "xyz" -- x2 :: Pair String

exchange :: (Pair a) -> (Pair a)
exchange (Pair x y) = Pair y x

-- exchange x1 будет Pair 12 42
-- exchange x2 будет Pair "xyz" "abc"
