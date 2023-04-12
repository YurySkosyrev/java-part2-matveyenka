package com.edu.threadpool.tasks;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * 2. Задан массив случайных целых чисел (от 1 до 300)
 * случайной длины (до 1 млн. элементов)
 * найти максимальный элемент в массиве двумя спобовами:
 * в одном потоке и используя 10 потоков.
 * Сравнить затраченное в обоих случаях время.
 */

public class Task2 {
    public static void main(String[] args) {
        int[] values = new int[1_000_000];
        Random random = new Random();

        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(300) + 1;
        }

        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        trackTime(() -> findMax(values));
        trackTime(() -> {
            try {
                return findMaxParralel(values, threadPool);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            return Integer.MIN_VALUE;
        });

        threadPool.shutdownNow();
    }

    private static int trackTime(Supplier<Integer> task) {
        long start = System.currentTimeMillis();
        int result = task.get();
        long finish = System.currentTimeMillis();
        System.out.println(result + " : " + (finish - start));
        return result;
    }

    private static int findMax(int[] values) {
        return IntStream.of(values)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    private static int findMaxParralel(int[] values, ExecutorService executorService)
            throws ExecutionException, InterruptedException {
        return executorService.submit(() -> IntStream.of(values)
                .parallel()
                .max()
                .orElse(Integer.MIN_VALUE)).get();
    }
}
