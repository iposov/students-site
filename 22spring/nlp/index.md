# Статистические методы обработки языка и речи

1. Примеры работы с nltk и рисование графиков (helloworld.ipynb)[http://nbviewer.jupyter.org/github/iposov/students-site/blob/master/22spring/nlp/helloworld.ipynb]
2. Jupyter, закон Ципфа: [jupyter-zipf.pdf](jupyter-zipf.pdf)
3. Дополнительные задания по закону Ципфа. N-грамм модели: [zipf-ngram.pdf](zipf-ngram.pdf)
4. Numpy, Линейная регрессия: (numpy-linear-regression.ipynb)[http://nbviewer.jupyter.org/github/iposov/students-site/blob/master/22spring/nlp/numpy-linear-regression.ipynb]
5. N-грамм модели в NLTK: (ngram.ipynb)[http://nbviewer.jupyter.org/github/iposov/students-site/blob/master/22spring/nlp/ngram.ipynb]
6. N-грамм модели и оценка модели: [ngrams.pdf](ngrams.pdf)
7. Классификация методом наивного байеса: [naive-bayes.pdf](naive-bayes.pdf), [naive-bayes.ipynb](http://nbviewer.jupyter.org/github/iposov/students-site/blob/master/22spring/nlp/naive-bayes.ipynb)

## Задания
### Закон Ципфа
* Подготовьте корпус
* Вычислите частотный словарь и постройте график логарифма частоты от логарифма ранка
* Аналогично, но приведите слова к начальной форме
* Вычислите линию регрессии, распечатайте ее коэффициенты и нарисуйте её на графике.

### N-грамм модели
* Подготовьте корпус
* Прочитайте его, разбив на предложения, а предложения на слова. Используйте встроенные в NLTK токенизаторы предложений и слов.
* Постройте модели MLE, Lindstone с $\lambda=1$ и $\lambda=0.1$.
* Перепишите код так, чтобы корпус разбивался на две части, примерно 80% в одной (обучающей) и 20% в другой (тестовой), обучите модели на обучающей части корпуса, посчитайте перплексити на второй части.
* Продолжение следует... другие модели, валидационный и тестовый корпус

## Работа с текстом

- Будем работать с текстами на русском
- Найденные тексты сохраняйте себе на диск в plain text, если у вас другой формат, самостоятельно разберитесь в библиотеках python, которые этот формат читают.
- Выкладывать в общий доступ чужие тексты нельзя (чаще всего). Храните их у себя на диске, выкладывайте в какое-то приватное облако, можете посылать в teams.
- Я буду запускать ваши программки на своих текстах, при необходимости, вы дадите свой текст.
- В блокнотах результаты будут видны по результатам обработки вашего текста.
- внимательно с кодировками