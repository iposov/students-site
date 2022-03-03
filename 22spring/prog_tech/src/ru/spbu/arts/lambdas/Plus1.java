package ru.spbu.arts.lambdas;

public class Plus1 implements Function {

    @Override
    public int evaluate(int x) {
        return x + 1;
    }
}
