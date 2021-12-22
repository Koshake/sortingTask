package lesson4;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E>  {

    Node<E> last;

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size == 1) {
            last = first;
        }
    }

    public void insertLast(E value) {
        if (isEmpty()) {
            insertFirst(value);
            return;
        }
        Node<E> newNode = new Node<E>(value, null);
        last.next = newNode;
        last = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        E removed = super.removeFirst();
        if (isEmpty()) {
            last = null;
        }
        return removed;
    }

    @Override
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
            } else if(current == last) {
                last = prev;
                last.next = null;
            }
        }
        return false;
    }

    public E getLast() {
        return last.item;
    }
}
