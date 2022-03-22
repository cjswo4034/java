package ds;

public interface List<E> {
    int size();

    boolean isEmpty();
    boolean contain(E e);

    boolean add(E e);
    boolean add(int index, E element);

    E remove(Object o);
    E remove(int index);

    E get(int index);
    E set(int index, E element);
}
