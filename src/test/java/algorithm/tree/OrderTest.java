package algorithm.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {
    private static final List<Integer> BST = Arrays.asList(0, 6, 4, 8, 3, 5, 7, 9);
    private static final int[] IN = {3, 4, 5, 6, 7, 8, 9};
    private static final int[] PRE = {6, 4, 3, 5, 8, 7, 9};
    private static final int[] POST = {3, 5, 4, 7, 9, 8, 6};

    @Test
    void inorder() {
        List<Integer> inorder1 = Order.inorder(BST, 1);
        List<Integer> inorder2 = Order.preToIn(PRE);
        List<Integer> inorder3 = Order.postToIn(POST);
        List<Integer> expected = new ArrayList<>();
        for (int e: IN) expected.add(e);

        assertEquals(expected, inorder1);
        assertEquals(expected, inorder2);
        assertEquals(expected, inorder3);
    }

    @Test
    void preorder() {
        List<Integer> preorder1 = Order.preorder(BST, 1);
        List<Integer> preorder2 = Order.postToPre(POST);
        List<Integer> expected = new ArrayList<>();
        for (int e: PRE) expected.add(e);

        assertEquals(expected, preorder1);
        assertEquals(expected, preorder2);
    }

    @Test
    void postorder() {
        List<Integer> postorder1 = Order.postorder(BST, 1);
        List<Integer> postorder2 = Order.preToPost(PRE);
        List<Integer> expected = new ArrayList<>();
        for (int e: POST) expected.add(e);

        assertEquals(expected, postorder1);
        assertEquals(expected, postorder2);
    }
}