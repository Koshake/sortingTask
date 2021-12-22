package lesson4;

public interface Deque<E> {
    void insertFirst(E value);

    void insertLast(E value);

    boolean insert(E value, int pos);

    E remove(E value);

    E removeFirst();

    E removeLast();

    int size();

    boolean isEmpty();

    boolean isFull();

    void display();
}
