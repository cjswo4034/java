## Queue

---

### 개념
- 먼저 입력된 자료가 먼저 출력되는 FIFO 형식의 자료구조이다.
- 자료가 입력되는 순서가 중요한 알고리즘에서 자주 사용된다.
- 주요 연산으로는 자료를 입력하는 PUSH와 자료를 제거하고 출력하는 POP이 있다. 

### 복잡도
- 시간복잡도
  - push: O(1)
  - pop : O(1)

### 용도
- 버퍼
- 스케쥴러

### 자바
- Linked List로 구현되어 있다.
- Deque는 List와 Circular Array로 구현되어 있다.

## 구현

---

### Linked List
```java
public class LinkedListQueue<E> implements Queue<E> {
    private Node<E> head, tail;
    private int size;

    public LinkedListQueue() {
        head = tail = new Node<>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean push(E e) {
        Node<E> node = new Node<>(e);

        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        size++;
        return true;
    }

    @Override
    public E poll() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        E value = head.value;
        head = head.next;
        size--;

        return value;
    }

    @Override
    public E peek() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return head.value;
    }


    class Node<E> {
        E value;
        Node<E> next;

        public Node() { }
        public Node(E value) {
            this.value = value;
        }
    }
}

```

### Array
```java
public class CircularArrayQueue<E> implements Queue<E> {
    private Object[] elements;
    private int size;
    private int head, tail;

    public CircularArrayQueue() {
        this.elements = new Object[1 << 5];
    }

    private void grow() {
        // 2^8 까지는 2배씩 증가, 그보다 크면 25%만
        final int oldCapacity = elements.length;
        int newCapacity = oldCapacity << 1;

        if (oldCapacity > (1 << 8)) {
            newCapacity = oldCapacity + (oldCapacity >> 2);
        }

        elements = Arrays.copyOf(elements, newCapacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean push(E e) {
        if (size + 1 == elements.length) {
            grow();
        }

        elements[tail++] = e;
        tail = tail % elements.length;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (size == 0)
            throw new EmptyStackException();

        E element = get(head++);
        head = head % elements.length;
        size--;
        return element;
    }

    @Override
    public E peek() {
        if (size == 0)
            throw new EmptyStackException();

        return get(head);
    }

    private E get(int idx) {
        return (E) elements[idx];
    }
}
```