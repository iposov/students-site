# Поиск коллокаций

1. Возьмите большой русский текст.
2. Токенизируйте его.
3. Сразу удалите частотные слова, для этого вы можете воспользоваться встроенным в NLTK словарём стоп-слов:
    ```
    import nltk
    nltk.download('stopwords')  # Это делается один раз после установки nltk
    
    from nltk.corpus import stopwords
    russian_stop_words = stopwords.words('russian')
   
    # посмотрим, какие есть стоп-слова 
    print(russian_stop_words)
   
    # для проверки конкретного слова
    print("он" in russian_stop_words)
    ```
4. Инициализируем поисковик коллокаций:
   ```
   from nltk.collocations import BigramCollocationFinder
   
   finder = BigramCollocationFinder.from_words(перечисление слов)
   ```
5. Отфильтровываем редкие пары с помощью `finder.apply_freq_filter(3)`, это запрещает искать коллокации из пар, которые встречаются реже, чем 3 раза.
6. Получаем доступ к различным метрикам оценки коллокаций:
   ```
   from nltk.collocations import BigramAssocMeasures
   bigram_measures = BigramAssocMeasures()
   ```

    А вот и перечисление, какие бывают метрики. Сначала таблица, которую мы рисовали в конспекте:
    ```

                w1    ~w1
             ------ ------
         w2 | n_ii | n_oi | = n_xi
             ------ ------
        ~w2 | n_io | n_oo |
             ------ ------
             = n_ix        TOTAL = n_xx
    ```
    <table>
    <thead>
    <tr><td>метрика</td><td>формула</td></tr>
    </thead>
    <tr><td>phi_sq</td><td>$\frac{(n_{ii} * n_{oo} - n_{io} * n_{oi})^2}{
                (n_{ii} + n_{io}) * (n_{ii} + n_{oi}) * (n_{io} + n_{oo}) * (n_{oi} + n_{oo})
            }$</td></tr>
    <tr><td>chi_sq</td><td>потом впишем</td></tr>
    <tr><td>fisher</td><td>потом впишем</td></tr>
    <tr><td>dice</td><td>$\frac{2n_{ii}}{n_{ix} + n_{xi}}$</td></tr>
    <tr><td>raw_freq</td><td>$\frac{n_ii}{n_xx}</td></tr>
    <tr><td>student_t</td><td>$\frac{n_{ii}
                - \frac{n_{ix}n_{xi}}{n_{xx}}
            }{\sqrt{n_{ii} + 10^{-20}}}$</td></tr>
    <tr><td>mi_like</td><td>$\frac{n_{ii}^3}{n_{ix}n_{xi}}$</td></tr>
    <tr><td>pmi</td><td>log2(n_ii * n_xx) - log2(n_ix*n_xi)</td></tr>
    <tr><td>likelihood_ratio</td><td>потом впишем</td></tr>
    <tr><td>poisson_stirling</td><td>n_ii * (log2(n_ii / (n_ix*n_xi / n_xx)) - 1)</td></tr>
    <tr><td>jaccard</td><td>$\frac{n_{ii}}{n_{ii} + n_{oi} + n_{io}}$</td></tr>
    </table>

   Чтобы посчитать коллокации по определенной метрике, пишите

    ```
    finder.score_ngrams(bigram_measures.raw_freq)  # для метрики raw_freq
    ```
   Вы получите пары из фраз и их оценок, из них нужно отобрать первые 50.
   
   Используйте три метрики: dice и еще две, какие понравятся. Если есть силы, и умение написать цикл, который перебирает все метрики, проверьте все. 
7. Создайте по два CSV файла на каждую метрику. В первом файле коллокации ищутся в исходной форме, во втором файле перед поиском коллокаций слова приводятся в начальную форму с помощью pymorphy.
     
   В CSV файл нунжо вывести по строчке на каждую коллокацию, два столбика на слова, последний столбик на значение метрики. Значения разделяются точкой с запятой. Например:
    ```
    крепкий;чай;0.54234
    крепкий;хозяйственник;0.444
    ответственный;исполнитель;0.225
    ```
   Откройте файлы в Excel или другом табличном редакторе. Какая метрика нашла более интересные коллокации в вашем тексте?

   Пример кода для вывода в файл:
    ```
    with open("a.csv", mode="w", encoding="utf8") as f:
       print("hello", file=f)
       # или
       f.write("hello\n")
    ```
8. Вместо CSV файлов можно вывести данные в pandas-таблицах.
