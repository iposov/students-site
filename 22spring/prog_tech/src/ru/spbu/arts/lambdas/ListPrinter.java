package ru.spbu.arts.lambdas;

import java.util.List;
import java.util.function.Function;

public class ListPrinter {
    public static void main(String[] args) {
        List<Integer> ints = List.of(3, 5, 6);
        printList(ints, x -> "!" + x);
        printList2(ints, x -> "*".repeat(x));
    }

    private static void printList(List<Integer> ints, NumbersDisplayer nd) {
        for (int i : ints)
            System.out.println(nd.display(i));
    }

    // Часто можно не создавать свой интерфейс, а пользоваться одним из существующих
    private static void printList2(List<Integer> ints, Function<Integer, String> nd) {
        for (int i : ints)
            System.out.println(nd.apply(i));
    }
}
