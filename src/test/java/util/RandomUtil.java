package util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class RandomUtil {
    private static final Random RANDOM = new Random();

    public static int getInt() {
        return RANDOM.nextInt();
    }

    public static int getInt(int bound) {
        return RANDOM.nextInt(bound);
    }

    public static int[] getDuplicableArray(int size) {
        return IntStream.range(0, size)
                .map(i -> RANDOM.nextInt())
                .toArray();
    }

    public static int[] getUniqueArray(int size) {
        Set<Integer> set = new HashSet<>();

        while (set.size() < size) {
            set.add(RANDOM.nextInt());
        }

        return set.stream().mapToInt(i -> i)
                .toArray();
    }

    public static int[] getUniqueArray(int size, int bound) {
        if (size > bound)
            throw new IllegalArgumentException("Size must be less than or equal to bound");

        Set<Integer> set = new HashSet<>();

        while (set.size() < size) {
            set.add(RANDOM.nextInt(bound));
        }

        return set.stream().mapToInt(i -> i)
                .toArray();
    }
}
