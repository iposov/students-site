# LaTeX typesetting system

TeX is a typesetting system, something similar in use as Microft Word, but it was made to make it easy to typeset mathematical formulas. It is a kind of a programming language, that outputs documents. It is possible to create books with it.

TeX was created by Donald Knuth (arts of Programming books). It is a kind of low level language. The most usefull expanstion is LaTeX, it adds commands, concepts to TeX and makes creating documents easier.

It is possible to create books, articles with LaTeX, we will look at these features, but the most usefull thing is the language to typeset formulas. This language is used in many other software, for example
 - Geogebra allows entering formulas in LaTeX `$f(x) = ax^2+bx+c$.
 - Jupyter Notebooks, uses LaTeX for formulas
 - KaTeX and ... — these are libraries to show mathematical formulas at web pages.

Installation
 - To install it locally use MikTeX (Windows), texlive (linux).
 - Use it online, I suggest Overleaf


An example of the latex document:

```latex
\documentclass{article}
\usepackage[utf8]{inputenc}

\title{Testing \LaTeX\ features}
\author{Ilya Posov}
\date{November 2021}

\begin{document}

\maketitle

\section{Introduction}
If we have an equation $ax^2+bx+c=0$, its solutions are:
$$x_{1,2}=\frac{-b\pm\sqrt{b^2-4ac}}{2a}$$

\end{document}
```
