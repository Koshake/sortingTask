package lesson4;

public class Main {
    public static void main(String[] args) {
        TwoSideLinkedList<Integer> list = new TwoSideLinkedListImpl<Integer>();


        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);

        list.insertLast(14);
        list.insertFirst(0);

        list.remove(2);
        list.removeFirst();
        System.out.println(list.contains(6));
        System.out.println(list.contains(3));

        list.display();


        Stack<Integer> stack = new LinkedListStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(14);

        stack.pop();
        stack.display();

        testHomeWork();

        testDequeWork();
    }

    public static void testHomeWork() {
        SimpleLinkedListImpl<Integer> list = new SimpleLinkedListImpl<Integer>();

        list.insertFirst(9);
        list.insertFirst(8);
        list.insertFirst(7);
        list.insertFirst(6);


        for (Integer value : list) {
            System.out.println("value " + value);
        }
    }

    public static void testDequeWork() {
        Deque<Integer> deque = new DequeImpl<Integer>();

        deque.insertFirst(9);
        deque.insertFirst(8);
        deque.insertFirst(7);
        deque.insertFirst(6);
        deque.insertLast(1);
        deque.insertLast(2);
        deque.insertLast(3);

        //deque.removeFirst();
        //deque.removeLast();

        //deque.remove(8);

        deque.display();

        deque.insert(100, 5);

        deque.display();
    }
}
