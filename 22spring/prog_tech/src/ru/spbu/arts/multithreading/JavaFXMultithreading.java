package ru.spbu.arts.multithreading;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class JavaFXMultithreading extends Application {
    private TextArea textArea;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello window");
        Parent parent = initInterface();
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();

        // будем вычислять простые числа и выписывать их в textArea.
        // нужно, чтобы в процессе вычисления не зависал интерфейс

        // Принцип при многопоточном программировании с пользовательским
        // интерфейсом: все действия с интерфейсом выполняются только
        // в потоке интерфейса. Это тот поток, в котором запускается
        // наша программа и выполняются все слушатели.

        // Вспомогательный класс в javafx: Task для создания
        // других потоков. Он делает вычисления (в другом потоке)
        // и возвращает результат вычислений
        Task<List<Integer>> primesTask = new Task<>() {
            @Override
            protected List<Integer> call() throws Exception {
                //выполняется в другом потоке
                List<Integer> primes = new ArrayList<>();

                for (int p = 1; p < 100000; p++)
                    if (isPrime(p))
                        //нельзя обращаться к интерфейсу
                        //textArea.appendText(p + "\n");
                        primes.add(p);

                return primes;
            }
        };


        //ставим слушателя на событие — успешное завершение
        //вычислений
        primesTask.setOnSucceeded(e -> {
            List<Integer> primes = primesTask.getValue();
            List<String> primesAsStrings = new ArrayList<>();
            for (Integer prime : primes)
                primesAsStrings.add("" + prime);
            textArea.setText(String.join(
                    ", ",
                    primesAsStrings
            ));
        });
        primesTask.run();
    }

    private Parent initInterface() {
        textArea = new TextArea();
        return textArea;
    }

    private boolean isPrime(int p) {
        if (p <= 1)
            return false;

        for (int i = 2; i < p; i++)
            if (p % i == 0)
                return false;

        return true;
    }
}
