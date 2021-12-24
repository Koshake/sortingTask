package lesson4;

public class DequeImpl<E>  implements Deque<E> {

    protected TwoSideNode<E> first;
    protected TwoSideNode<E> last;
    protected int size;

    public void insertFirst(E value) {
       TwoSideNode<E> newNode = new TwoSideNode<E>(value, null, first);
       if (!isEmpty()) {
           first.prev = newNode;
       }
       first = newNode;
       size++;
       if (size == 1) {
           last = first;
       }
    }

    public void insertLast(E value) {
        if (isEmpty()) {
            insertFirst(value);
        }
        TwoSideNode<E> newNode = new TwoSideNode<E>(value, last, null);
        last.next = newNode;
        last = newNode;
        size++;
    }

    public boolean insert(E value, int pos) {
        if (pos == 0) {
            insertFirst(value);
        } else if (pos == size) {
            insertLast(value);
        } else if (pos > size) {
            return false;
        } else {
            int i = 1;
            TwoSideNode<E> current = first;
            while (current != null) {
                current = current.next;
                if (i == pos - 1) {
                    TwoSideNode<E> newNode = new TwoSideNode<E>(value, current, current.next);
                    current.next.prev = newNode;
                    current.next = newNode;
                    return true;
                }
                i++;
            }
        }
        return true;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        TwoSideNode<E> removed = first;
        first = removed.next;
        if (size != 1) {
            first.prev = null;
        }
        removed.next = null;
        size--;
        return removed.item;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        TwoSideNode<E> removed = last;
        if (size == 1) {
            last = null;
            first = null;
        } else {
            last = removed.prev;
            last.next = null;
            removed.prev = null;
        }
        size--;
        return removed.item;
    }

    public E remove(E value) {

        if (first.item == value) {
            return removeFirst();
        }
        if (last.item == value) {
            return removeLast();
        }
        TwoSideNode<E> current = first;
        while (current != null) {
            current = current.next;
            if (current.item == value) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                current.next = null;
                current.prev = null;
                size--;
                return current.item;
            }
        }

        return null;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return false;
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        TwoSideNode<E> current = first;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.append("]").toString();
    }

    class TwoSideNode<E> {
        E item;
        TwoSideNode<E> prev;
        TwoSideNode<E> next;

        public TwoSideNode(E item, TwoSideNode<E> prev, TwoSideNode<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
