package threadPoolExample;

import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    public static void main(String[] args) {

        // создаётся один поток
        Executors.newSingleThreadExecutor();

        // pool из 5 потоков
        Executors.newFixedThreadPool(5);

        // безграничный метод, сколько задач отправили, столько будет потоков
        // при этом если в следующий раз передаётся меньше потоков, то новые не будут созданы
        // если больше, то создадутся новые.
        Executors.newCachedThreadPool();

        // выполнение задач с задержкой по времени
        Executors.newScheduledThreadPool(3);

        // создаёт thread pool на основании другой реализации thread pool
        // ForlJoinPool - создаёт пулл оптимального размера, исходя из колличества
        // свободных процессоров, можем не задумываться о колличестве потоков
        Executors.newWorkStealingPool();


    }
}
