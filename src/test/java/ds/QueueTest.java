package ds;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import util.RandomUtil;

import java.util.EmptyStackException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class QueueTest {
    private static final int RAND_SIZE = 1000;
    private static final int[] RAND_ARR = RandomUtil.getUniqueArray(RAND_SIZE);

    @TestFactory
    Stream<DynamicTest> testsForPush() {
        return Stream.of(CircularArrayQueue.class, LinkedListQueue.class)
                .map(clazz -> dynamicTest(clazz.getSimpleName(), () -> push(clazz)));
    }

    @TestFactory
    Stream<DynamicTest> testsForPoll() {
        return Stream.of(CircularArrayQueue.class, LinkedListQueue.class)
                .map(clazz -> dynamicTest(clazz.getSimpleName(), () -> poll(clazz)));
    }

    @TestFactory
    Stream<DynamicTest> testsForPeek() {
        return Stream.of(CircularArrayQueue.class, LinkedListQueue.class)
                .map(clazz -> dynamicTest(clazz.getSimpleName(), () -> peek(clazz)));
    }

    private <T extends Queue<Integer>> void push(Class<T> clazz) throws Exception {
        Queue<Integer> queue = create(clazz);

        for (int i = 0; i < RAND_SIZE; i++) {
            int finalI = i;
            assertDoesNotThrow(() -> queue.push(RAND_ARR[finalI]));
            assertEquals(i + 1, queue.size());
        }
    }

    private <T extends Queue<Integer>> void poll(Class<T> clazz) throws Exception {
        Queue<Integer> queue = create(clazz, RAND_ARR);

        for (int i = 0; i < RAND_SIZE; i++) {
            Integer value = assertDoesNotThrow(queue::poll);
            assertEquals(RAND_ARR[i], value);
            assertEquals(RAND_SIZE - i - 1, queue.size());
        }

        assertThrows(EmptyStackException.class, queue::poll);
    }

    private <T extends Queue<Integer>> void peek(Class<T> clazz) throws Exception {
        Queue<Integer> queue = create(clazz, RAND_ARR);

        for (int i = 0; i < RAND_SIZE; i++) {
            Integer value = assertDoesNotThrow(queue::peek);
            assertEquals(RAND_ARR[0], value);
        }

        assertEquals(RAND_SIZE, queue.size());
        assertDoesNotThrow(queue::peek);
    }

    <T extends Queue<Integer>> Queue<Integer> create(Class<T> clazz) throws Exception {
        return clazz.getConstructor().newInstance();
    }

    <T extends Queue<Integer>> Queue<Integer> create(Class<T> clazz, int[] elements) throws Exception {
        Queue<Integer> queue = clazz.getConstructor().newInstance();

        for (int e : elements) {
            queue.push(e);
        }

        return queue;
    }
}