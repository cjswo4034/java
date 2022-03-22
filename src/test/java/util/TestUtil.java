package util;

import org.junit.jupiter.api.DynamicTest;

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

    @FunctionalInterface
    public interface ThrowingConsumer<T, E extends Exception> {
        void accept(T t) throws E;
    }
}
