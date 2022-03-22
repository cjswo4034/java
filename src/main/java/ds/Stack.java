package ds;

public interface Stack<E> {
    int size();

    boolean isEmpty();

    boolean push(E e);

    E peek();

    E pop();
}
