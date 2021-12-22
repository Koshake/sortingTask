package lesson4;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E>, Iterable<E> {

    protected  int size;
    protected Node<E> first;

    public void insertFirst(E value) {
        first = new Node<E>(value, first);
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removed = first;
        first = removed.next;
        removed.next = null;
        size--;
        return removed.item;
    }

    public boolean remove(E value) {
        if (first.item == value) {
            removeFirst();
            return true;
        }
        Node<E> current = first;
        Node<E> prev = null;
        while (current != null) {
            prev = current;
            current = current.next;
            if (current.item == value) {
                Node<E> removed = current;
                prev.next = removed.next;
                removed.next = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean contains(E value) {
        Node<E> current = first;
        while (current != null) {
            if (current.item == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = first;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.append("]").toString();
    }

    public E getFirst() {
        return first.item;
    }

    class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    public Iterator<E> iterator() {
        return new ListIterator<E>(this);
    }

    private class ListIterator<E> implements Iterator<E> {

        Node<E> current;
        public ListIterator(LinkedList data) {
            current = (Node<E>)first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            E value = current.item;
            current = current.next;
            return value;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
