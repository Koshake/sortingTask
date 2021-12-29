package lesson6;

import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> root;
    private int size;
    private int maxLevel;
    private int currentLevel;

    public TreeImpl(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    private class NodeAndParent {
        private Node<E> current;
        private Node<E> parent;

        public NodeAndParent(Node<E> current, Node<E> parent) {
            this.current = current;
            this.parent = parent;
        }
    }

    private class BalancedAndHeight {
        private boolean isBalanced;
        private int height;

        public BalancedAndHeight(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public boolean add(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        if (nodeAndParent.current != null) {
            return false;
        }

        Node<E> parent = nodeAndParent.parent;
        Node<E> node = new Node<E>(value);

        if (isEmpty()) {
            node.setLevel(1);
            root = node;
        } else if (nodeAndParent.parent.getLevel() == maxLevel) {
            return false;
        } else if (parent.isLeftChild(value)) {
            parent.setLeftChild(node);
            node.setLevel(parent.getLevel() + 1);
        } else {
            parent.setRightChild(node);
            node.setLevel(parent.getLevel() + 1);
        }
        currentLevel = node.getLevel();
        size++;
        return true;
    }

    public boolean contains(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        return nodeAndParent.current != null;
    }

    private NodeAndParent doFind(E value) {
        Node<E> current = root;
        Node<E> parent = null;

        while (current != null) {
            if (current.getValue().equals(value)) {
                return new NodeAndParent(current, parent);
            }

            parent = current;

            if (current.isLeftChild(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        return new NodeAndParent(null, parent);
    }

    public boolean remove(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        Node<E> removed = nodeAndParent.current;
        Node<E> parent = nodeAndParent.parent;

        if (removed == null) {
            return false;
        } else if (removed.isLeaf()) {
            removeLeafNode(removed, parent);
        } else if (removed.hasOnlyOneChild()) {
            removeNodeWithOneChild(removed, parent);
        } else {
            removeNodeWithAllChildren(removed, parent);
        }
        size--;
        return false;
    }

    private void removeNodeWithAllChildren(Node<E> removed, Node<E> parent) {
        Node<E> successor = getSuccessor(removed);

        if (removed == root) {
            root = successor;
        } else if (parent.isLeftChild(successor.getValue())) {
            parent.setLeftChild(successor);
        } else {
            parent.setRightChild(successor);
        }
    }

    private Node<E> getSuccessor(Node<E> removed) {
        Node<E> successor = removed;
        Node<E> successorParent = null;
        Node<E> current = removed.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != removed.getRightChild() && successorParent != null) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removed.getRightChild());
        }
        successor.setLeftChild(removed.getLeftChild());
        return successor;
    }

    private void removeNodeWithOneChild(Node<E> removed, Node<E> parent) {
        Node<E> child = removed.getLeftChild() == null
                ? removed.getRightChild()
                : removed.getLeftChild();
        
        if (removed == root) {
            root = child;
        } else if (parent.isLeftChild(removed.getValue())) {
            parent.setLeftChild(child);
        } else {
            parent.setRightChild(child);
        }
    }

    private void removeLeafNode(Node<E> removed, Node<E> parent) {
        if (removed == root) {
            root = null;
        } else if (parent.isLeftChild(removed.getValue())) {
            parent.setLeftChild(null);
        } else {
            parent.setRightChild(null);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void display() {
        Stack<Node<E>> globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node<E>> localStack = new Stack();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node<E> tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    public void traverse(TraversMode mode) {
        switch (mode) {
            case PRE_ORDER :
                preOrder(root);
                break;
            case IN_ORDER :
                inOrder(root);
                break;
            case POST_ORDER :
                postOrder(root);
                break;
        }
        System.out.println();
    }

    private void preOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        System.out.print(current.getValue() + " ");
        preOrder(current.getLeftChild());
        preOrder(current.getRightChild());
    }

    private void inOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild());
        System.out.print(current.getValue() + " ");
        inOrder(current.getRightChild());
    }

    private void postOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        postOrder(current.getLeftChild());
        postOrder(current.getRightChild());
        System.out.print(current.getValue() + " ");
    }

    private BalancedAndHeight isBalanced(Node<E> node, int depth) {
        if (node == null) {
            return new BalancedAndHeight(true, -1);
        }

        BalancedAndHeight left = isBalanced(node.getLeftChild(), depth + 1);
        BalancedAndHeight right = isBalanced(node.getRightChild(), depth + 1);

        boolean isBalanced = Math.abs(left.height - right.height) <= 1;
        boolean subtreeBalanced = left.isBalanced && right.isBalanced;

        int h = Math.max(left.height, right.height) + 1;
        return new BalancedAndHeight(isBalanced && subtreeBalanced, h);
    }

    public boolean isBalancedTree() {
        return isBalanced(root, 0).isBalanced;
    }

}
