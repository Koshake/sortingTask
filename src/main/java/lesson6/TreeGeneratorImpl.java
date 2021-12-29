package lesson6;

import java.util.Random;

public class TreeGeneratorImpl implements TreeGenerator {

    final int level;
    final int min;
    final int max;

    public TreeGeneratorImpl(int level, int min, int max) {
        this.level = level;
        this.min = min;
        this.max = max;
    }

    public Tree<Integer> generateTree() {
        TreeImpl<Integer> tree = new TreeImpl<Integer>(level);
        while (tree.getCurrentLevel() < level) {
            tree.add(generateValue());
        }
        return tree;
    }

    public Integer generateValue() {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
