package com.edu.threadpool.example;

import java.util.concurrent.*;

public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // создаётся один поток
//        Executors.newSingleThreadExecutor();



        // безграничный метод, сколько задач отправили, столько будет потоков
        // при этом если в следующий раз передаётся меньше потоков, то новые не будут созданы
        // если больше, то создадутся новые.
//        Executors.newCachedThreadPool();

        // выполнение задач с задержкой по времени
//        Executors.newScheduledThreadPool(3);

        // создаёт thread pool на основании другой реализации thread pool
        // ForlJoinPool - создаёт пулл оптимального размера, исходя из колличества
        // свободных процессоров, можем не задумываться о колличестве потоков
//        Executors.newWorkStealingPool();

        // pool из 5 потоков

        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(4);
        threadPool.scheduleAtFixedRate(() -> System.out.println("OK!"), 2L, 2L, TimeUnit.SECONDS);

//        threadPool.shutdown();
//        threadPool.awaitTermination(1L, TimeUnit.HOURS);
    }

    private static void test() throws InterruptedException, ExecutionException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        Future<Integer> future = threadPool.submit(() -> {
            Thread.sleep(2000);
            System.out.println("It's callable");
            return 1;
        });

        System.out.println("Result: " + future.get());
        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.HOURS);
        System.out.println("main end");
    }
}
