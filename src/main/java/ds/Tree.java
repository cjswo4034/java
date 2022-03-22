package ds;

public interface Tree<E> {
    void insert(E e);
    boolean search(E e);
    boolean delete(E e);

    java.util.List<E> inorder();
    java.util.List<E> preorder();
    java.util.List<E> postorder();

    int size();
    boolean isEmpty();
    void checkIsEmpty();
}
