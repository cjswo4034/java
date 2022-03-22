package ds;

public interface Queue<E> {
    int size();

    boolean push(E e);

    E poll();

    E peek();
}
