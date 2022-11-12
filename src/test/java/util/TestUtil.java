package util;

import org.junit.jupiter.api.DynamicTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class TestUtil {
    @SafeVarargs
    public static <T> Stream<DynamicTest> createTests(Consumer<Class<? extends T>> consumer, Class<? extends T>... classes) {
        return Stream.of(classes)
                .map(clazz -> dynamicTest(clazz.getSimpleName(), () -> consumer.accept(clazz)));
    }

    public static <T> Consumer<T> throwingConsumerWrapper(ThrowingConsumer<T, Exception> throwingConsumer) {
        return var -> {
            try {
                throwingConsumer.accept(var);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        };
    }

    public static int[] listToArr(List<Integer> list) {
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int[][] strMatrixToIntMatrix(String str) {
        String[] splicedStr = Arrays.stream(str.split("(], \\[)"))
                .map(row -> row.replaceAll("[\\[\\]]", ""))
                .toArray(String[]::new);
        return Arrays.stream(splicedStr)
                .map(TestUtil::strArrToIntArr)
                .toArray(int[][]::new);
    }

    public static int[] strArrToIntArr(String row) {
        return Arrays.stream(row.split("[,]"))
                .map(String::strip)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int countLeftBrace(String str) {
        return (int) str.chars()
                .filter(ch -> ch == '[')
                .count();
    }

    @FunctionalInterface
    public interface ThrowingConsumer<T, E extends Exception> {
        void accept(T t) throws E;
    }
}
