package ds;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static util.RandomUtil.getUniqueArray;

class ListTest {
    private static final int ARR_SIZE = 1000;
    private static final int[] RAND_ARR = getUniqueArray(ARR_SIZE);
    private static final int[] RAND_INDICES = getUniqueArray(ARR_SIZE, ARR_SIZE);

    @TestFactory
    Stream<DynamicTest> testForAdd() {
        return Stream.of(SingleLinkedList.class, DoubleLinkedList.class, ArrayList.class)
                .map(clazz -> dynamicTest(clazz.getSimpleName(), () -> add(clazz)));
    }

    @TestFactory
    Stream<DynamicTest> testForAddByIndex() {
        return Stream.of(SingleLinkedList.class, DoubleLinkedList.class, ArrayList.class)
                .map(clazz -> dynamicTest(clazz.getSimpleName(), () -> addByIndex(clazz)));
    }

    @TestFactory
    Stream<DynamicTest> testForRemove() {
        return Stream.of(SingleLinkedList.class, DoubleLinkedList.class, ArrayList.class)
                .map(clazz -> dynamicTest(clazz.getSimpleName(), () -> remove(clazz)));
    }

    @TestFactory
    Stream<DynamicTest> testForGet() {
        return Stream.of(SingleLinkedList.class, DoubleLinkedList.class, ArrayList.class)
                .map(clazz -> dynamicTest(clazz.getSimpleName(), () -> get(clazz)));
    }

    @TestFactory
    Stream<DynamicTest> testForSet() {
        return Stream.of(SingleLinkedList.class, DoubleLinkedList.class, ArrayList.class)
                .map(clazz -> dynamicTest(clazz.getSimpleName(), () -> set(clazz)));
    }

    private <E extends List<Integer>> void add(Class<E> clazz) throws Exception {
        List<Integer> list = create(clazz);

        for (int i = 0; i < ARR_SIZE; i++) {
            assertTrue(list.add(RAND_ARR[i]));
            assertEquals(RAND_ARR[i], list.get(i));
        }

        assertEquals(ARR_SIZE, list.size());
    }

    private <E extends List<Integer>> void addByIndex(Class<E> clazz) throws Exception {
        List<Integer> list = create(clazz);

        for (int i = 0; i < ARR_SIZE; i++) {
            assertTrue(list.add(0, RAND_ARR[i]));
            assertEquals(RAND_ARR[i], list.get(0));
        }

        for (int i = 0; i < ARR_SIZE; i++) {
            assertEquals(RAND_ARR[ARR_SIZE - i - 1], list.get(i));
        }

        assertEquals(ARR_SIZE, list.size());
    }

    private <E extends List<Integer>> void remove(Class<E> clazz) throws Exception {
        List<Integer> list = create(clazz, RAND_ARR);

        int value;
        for (int i : RAND_INDICES) {
            value = list.remove((Integer) RAND_ARR[i]);
            assertEquals(RAND_ARR[i], value);
            assertFalse(list.contain(RAND_ARR[i]));
        }

        assertEquals(0, list.size());
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.remove(RAND_ARR[0]));
    }

    private <E extends List<Integer>> void get(Class<E> clazz) throws Exception {
        List<Integer> list = create(clazz, RAND_ARR);

        for (int i : RAND_INDICES) {
            assertEquals(RAND_ARR[i], list.get(i));
        }

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(ARR_SIZE));
    }

    private <E extends List<Integer>> void set(Class<E> clazz) throws Exception {
        List<Integer> list = create(clazz, RAND_ARR);

        for (int i = 0, value; i < ARR_SIZE; i++) {
            final int element = i;
            value = assertDoesNotThrow(() -> list.set(element, element));
            assertEquals(element, value);
            assertEquals(value, list.get(i));
        }

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(ARR_SIZE));
    }

    private static <E extends List<Integer>> List<Integer> create(Class<E> clazz) throws Exception {
        return clazz.getConstructor().newInstance();
    }

    private static <E extends List<Integer>> List<Integer> create(Class<E> clazz, int[] arr) throws Exception {
        List<Integer> list = clazz.getConstructor().newInstance();
        for (int e : arr) {
            list.add(e);
        }
        return list;
    }
}