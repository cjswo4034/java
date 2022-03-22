package ds;

import algorithm.tree.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static util.TestUtil.listToArr;

class TreeTest {
    private static final int ARR_SIZE = 1000;
    private static final int[] RAND_ARR = RandomUtil.getUniqueArray(ARR_SIZE, ARR_SIZE * 10);
    private static final ArrayList<Integer> sortedArr = new ArrayList<>();

    private java.util.List<Tree<Integer>> trees;

    @BeforeAll
    static void init() {
        for (int e : RAND_ARR) sortedArr.add(e);
        sortedArr.sort(Integer::compareTo);
    }

    @BeforeEach
    void setup() {
        trees = Collections.singletonList(new BinarySearchTree<>(Integer::compareTo));
    }

    @TestFactory
    Stream<DynamicTest> inorder() {
        return trees.stream()
                .map(tree -> dynamicTest(tree.getClass().getSimpleName(), () -> inorder(tree)));
    }

    void inorder(Tree<Integer> tree) {
        init(tree);

        assertEquals(sortedArr, tree.inorder());
    }

    @TestFactory
    Stream<DynamicTest> preorder() {
        return trees.stream()
                .map(tree -> dynamicTest(tree.getClass().getSimpleName(), () -> preorder(tree)));
    }

    void preorder(Tree<Integer> tree) {
        init(tree);

        int[] postorder = listToArr(tree.postorder());
        int[] preorder1 = listToArr(tree.preorder());
        int[] preorder2 = listToArr(Order.postToPre(postorder));
        int[] inorder1 = listToArr(Order.preToIn(preorder1));
        int[] inorder2 = listToArr(Order.preToIn(preorder2));
        int[] expected = listToArr(sortedArr);

        assertArrayEquals(expected, inorder1);
        assertArrayEquals(expected, inorder2);
        assertArrayEquals(preorder1, preorder2);
    }

    @TestFactory
    Stream<DynamicTest> postorder() {
        return trees.stream()
                .map(tree -> dynamicTest(tree.getClass().getSimpleName(), () -> postorder(tree)));
    }

    void postorder(Tree<Integer> tree) {
        init(tree);

        int[] preorder = listToArr(tree.preorder());
        int[] postorder1 = listToArr(tree.postorder());
        int[] postorder2 = listToArr(Order.preToPost(preorder));
        int[] inorder1 = listToArr(Order.postToIn(postorder1));
        int[] inorder2 = listToArr(Order.postToIn(postorder2));
        int[] expected = listToArr(sortedArr);

        assertArrayEquals(expected, inorder1);
        assertArrayEquals(expected, inorder2);
        assertArrayEquals(postorder1, postorder2);
    }

    @TestFactory
    Stream<DynamicTest> insert() {
        return trees.stream()
                .map(tree -> dynamicTest(tree.getClass().getSimpleName(), () -> insert(tree)));
    }

    void insert(Tree<Integer> tree) {
        for (int e : RAND_ARR) {
            assertDoesNotThrow(() -> tree.insert(e));
        }
    }

    @TestFactory
    Stream<DynamicTest> search() {
        return trees.stream()
                .map(tree -> dynamicTest(tree.getClass().getSimpleName(), () -> search(tree)));
    }

    void search(Tree<Integer> tree) {
        init(tree);

        for (int i = 0; i < ARR_SIZE; i++) {
            if (i % 5 == 0) tree.delete(RAND_ARR[i]);
        }

        for (int i = 0; i < ARR_SIZE; i++) {
            if (i % 5 == 0)
                assertFalse(tree.search(RAND_ARR[i]));
            else
                assertTrue(tree.search(RAND_ARR[i]));
        }
    }

    @TestFactory
    Stream<DynamicTest> delete() {
        return trees.stream()
                .map(tree -> dynamicTest(tree.getClass().getSimpleName(), () -> delete(tree)));
    }

    void delete(Tree<Integer> tree) {
        init(tree);

        for (int e : RAND_ARR) {
            assertTrue(tree.delete(e));
            assertFalse(tree.search(e));
            if (tree.size() > 0)
                assertThrows(NoSuchElementException.class, () -> tree.delete(e));
        }

        assertTrue(tree.isEmpty());
        assertThrows(IllegalArgumentException.class, () -> tree.delete(RAND_ARR[0]));
    }

    void init(Tree<Integer> tree) {
        for (int e : RAND_ARR) {
            tree.insert(e);
        }
    }
}
