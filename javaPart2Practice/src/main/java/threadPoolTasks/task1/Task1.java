package threadPoolTasks.task1;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 1. Написать программу, бесконечно считывающую
 * пользовательские числа из консоли.
 * Эти числа представляют собой количество секунд.
 * При каждом вводе числа, должна создаваться задача,
 * которая засыпает на введённое число секунд и затем
 * выводит "Я спал N секунд".
 * Однако нужно сделать так, чтобы все задачи выполнялись в
 * одном и том же потоке в поряде ввода.
 * Т.е. в программе есть 2 потока: главный и поток для
 * выполнения всех задач по очереди.
 * При вводе отрицательного числа программа должна завершать свою работу.
 * Второе решение - несколько потоков в пуле. Посчитать колличество
 * обработанных задач каждом потоком
 */
public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadExecutor = Executors.newSingleThreadExecutor();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int seconds = scanner.nextInt();
            if(seconds < 0) {
                break;
            }
            threadExecutor.submit(() -> {
                Thread.sleep(seconds * 1000);
                System.out.println(String.format("Поток '%s' спал '%d' секунд", Thread.currentThread().getName(), seconds));
                return seconds;
            });
        }

        threadExecutor.shutdown();
        threadExecutor.awaitTermination(10L, TimeUnit.MINUTES);
    }
}
