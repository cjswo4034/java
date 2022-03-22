package ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import util.RandomUtil;

import java.util.EmptyStackException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class StackTest {
    private static final int ARR_SIZE = 1000;
    private static final int[] RAND_ARR = RandomUtil.getUniqueArray(ARR_SIZE);

    private Stream<Stack<Integer>> stackStream;

    @BeforeEach
    void setUp() {
        stackStream = Stream.of(new ArrayStack<>(), new LinkedListStack<>());
    }

    @TestFactory
    Stream<DynamicTest> testsForPush() {
        return stackStream
                .map(stack -> dynamicTest(stack.getClass().getSimpleName(), () -> push(stack)));
    }

    @TestFactory
    Stream<DynamicTest> testsForPop() {
        return stackStream
                .map(stack -> dynamicTest(stack.getClass().getSimpleName(), () -> pop(stack)));
    }

    @TestFactory
    Stream<DynamicTest> testsForPeek() {
        return stackStream
                .map(stack -> dynamicTest(stack.getClass().getSimpleName(), () -> peek(stack)));
    }

    private void push(Stack<Integer> stack) {
        for (int e : RAND_ARR) {
            assertTrue(stack.push(e));
            assertEquals(e, stack.peek());
        }

        assertEquals(ARR_SIZE, stack.size());
    }

    private void pop(Stack<Integer> stack) {
        init(stack);

        for (int i = ARR_SIZE - 1; i >= 0; i--) {
            int value = assertDoesNotThrow(stack::pop);
            assertEquals(RAND_ARR[i], value);
        }

        assertTrue(stack::isEmpty);
        assertThrows(EmptyStackException.class, stack::pop);
    }

    private void peek(Stack<Integer> stack) {
        init(stack);

        for (int i = 0, len = RAND_ARR.length; i < len; i++) {
            int value = assertDoesNotThrow(stack::peek);
            assertEquals(RAND_ARR[ARR_SIZE - 1], value);
        }

        assertEquals(ARR_SIZE, stack.size());
    }

    private void init(Stack<Integer> stack) {
        for (int e : RAND_ARR) {
            stack.push(e);
        }
    }
}