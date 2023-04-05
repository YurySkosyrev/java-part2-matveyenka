package produserConsumerTask;

import java.util.Random;

/**
 * Утилитный класс для получения очередного случайного числа
 */

public final class RandomUtil {

    private static final Random RANDOM = new Random();
    private static final int DEFAULT_BOUND = 10;

    private RandomUtil() {
    }

    public static int getRandom() {
        return RANDOM.nextInt(DEFAULT_BOUND);
    }

    public static int getRandom(int bound) {
        return RANDOM.nextInt(bound);
    }
}
