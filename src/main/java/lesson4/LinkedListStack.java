package lesson4;

public class LinkedListStack<E> implements Stack<E> {

    private final LinkedList<E> data;

    public LinkedListStack() {
        data = new SimpleLinkedListImpl<E>();
    }

    public void push(E value) {
        data.insertFirst(value);
    }

    public E pop() {
        return data.removeFirst();
    }

    public E peek() {
        return data.getFirst();
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public boolean isFull() {
        return false;
    }

    public void display() {
        data.display();
    }

    @Override
    public String toString() {
        return "LinkedListStack { data=" + data + "}";
    }
}
