package ds;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import util.RandomUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class HeapTest {
    private static final int ARR_SIZE = 50;
    private static final int[] RAND_ARR = RandomUtil.getUniqueArray(ARR_SIZE);
    private static int[] sortedArr;
    private static int[] reversedArr;

    private Stream<Heap<Integer>> heapStream;

    @BeforeAll
    static void init() {
        reversedArr = Arrays.copyOf(RAND_ARR, ARR_SIZE);
        Arrays.sort(reversedArr);

        sortedArr = new int[ARR_SIZE];
        for (int i = 0; i < ARR_SIZE; i++) {
            sortedArr[i] = reversedArr[ARR_SIZE - i - 1];
        }
    }

    @BeforeEach
    void setUp() {
        Comparator<Integer> comparator = Comparator.comparingInt(e -> e);
        heapStream = Stream.of(new MaxHeap<>(comparator), new MinHeap<>(comparator));
    }

    @TestFactory
    Stream<DynamicTest> insert() {
        return heapStream
                .map(heap -> dynamicTest(heap.getClass().getSimpleName(), () -> insert(heap)));
    }

    @TestFactory
    Stream<DynamicTest> peek() {
        return heapStream
                .map(heap -> dynamicTest(heap.getClass().getSimpleName(), () -> peek(heap)));
    }

    @TestFactory
    Stream<DynamicTest> delete() {
        return heapStream
                .map(heap -> dynamicTest(heap.getClass().getSimpleName(), () -> delete(heap)));
    }

    private void insert(Heap<Integer> heap) {
        if (isMaxHeap(heap)) {
            insertForMaxHeap(heap);
        } else {
            insertForMinHeap(heap);
        }
    }

    private void insertForMaxHeap(Heap<Integer> heap) {
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < ARR_SIZE; i++) {
            maxValue = Math.max(maxValue, RAND_ARR[i]);

            assertTrue(heap.insert(RAND_ARR[i]));
            assertEquals(maxValue, heap.peek());
            assertEquals(i + 1, heap.size());
        }
    }

    private void insertForMinHeap(Heap<Integer> heap) {
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < ARR_SIZE; i++) {
            minValue = Math.min(minValue, RAND_ARR[i]);

            assertTrue(heap.insert(RAND_ARR[i]));
            assertEquals(minValue, heap.peek());
            assertEquals(i + 1, heap.size());
        }
    }

    private void peek(Heap<Integer> heap) {
        addAll(heap);

        boolean isMaxHeap = isMaxHeap(heap);
        for (int i = 0, count = 0, value; i < ARR_SIZE; i++) {
            if ((i + 1) % 5 == 0) {
                count++;
                assertDoesNotThrow(heap::delete);
            }

            value = isMaxHeap ? sortedArr[count] : reversedArr[count];
            assertEquals(value, heap.peek());
        }
    }

    private void delete(Heap<Integer> heap) {
        addAll(heap);

        boolean isMaxHeap = isMaxHeap(heap);
        for (int e : isMaxHeap ? sortedArr : reversedArr) {
            int value = assertDoesNotThrow(heap::delete);
            assertEquals(e, value);
        }

        assertTrue(heap::isEmpty);
        assertThrows(ArrayIndexOutOfBoundsException.class, heap::delete);
    }

    private void addAll(Heap<Integer> heap) {
        for (int e : RAND_ARR) {
            heap.insert(e);
        }
    }

    private boolean isMaxHeap(Heap<Integer> heap) {
        return heap.getClass().equals(MaxHeap.class);
    }
}