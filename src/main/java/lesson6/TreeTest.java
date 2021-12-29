package lesson6;

import java.util.ArrayList;
import java.util.List;

public class TreeTest {

    public static void main(String[] args) {

/*        Tree<Integer> tree = new TreeImpl(4);

        tree.add(60);
        tree.add(50);
        tree.add(66);
        tree.add(40);
        tree.add(55);
        tree.add(70);
        tree.add(31);
        tree.add(45);
        tree.add(42);
        tree.add(43);
        tree.add(69);
        tree.add(67);
        tree.add(68);
        tree.add(81);

        tree.display();

        tree.display();
        tree.traverse(Tree.TraversMode.IN_ORDER);
        tree.traverse(Tree.TraversMode.PRE_ORDER);
        tree.traverse(Tree.TraversMode.POST_ORDER);*/


        final int TREE_COUNT = 25;
        TreeGenerator<Integer> generator = new TreeGeneratorImpl(4, -25, 25);
        List<Tree<Integer>> list = new ArrayList<Tree<Integer>>();
        for (int i = 0; i < TREE_COUNT; i++) {
            list.add(generator.generateTree());
        }

        int balancedCount = 0;
        for (Tree<Integer> integerTree : list) {
            if (integerTree.isBalancedTree()) {
                balancedCount++;
            }
        }
        int balancedPercent = 100 * balancedCount/list.size();
        System.out.format("Balanced %d percent", balancedPercent);

    }

}
