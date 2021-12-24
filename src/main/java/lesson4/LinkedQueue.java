package lesson4;

public class LinkedQueue<E> implements Queue<E> {

    private final TwoSideLinkedList<E> linkedList;

    public LinkedQueue() {
        this.linkedList = new TwoSideLinkedListImpl<E>();
    }

    public boolean insert(E value) {
        linkedList.insertLast(value);
        return true;
    }

    public E remove() {
        return linkedList.getFirst();
    }

    public E peek() {
        return linkedList.getFirst();
    }

    public int size() {
        return linkedList.size();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public boolean isFull() {
        return false;
    }

    public void display() {
        linkedList.display();
    }

    @Override
    public String toString() {
        return "LinkedQueue{" +
                "data=" + linkedList +
                '}';
    }
}
