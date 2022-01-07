package lesson6;

public interface TreeGenerator<E extends Comparable<? super E>> {

    public Tree<E> generateTree();

    public E generateValue();
}
