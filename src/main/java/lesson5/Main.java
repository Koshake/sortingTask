package lesson5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println(Pow.pow(2, 10));

        List<Thing> items = new ArrayList<Thing>();

        items.add(new Thing("Гантеля", 500, 2));
        items.add(new Thing("Утюг", 2000, 1));
        items.add(new Thing("Ноутбук", 100000, 4));
        items.add(new Thing("Часы", 20000, 3));

        Thief thief = new Thief(5);

        System.out.println(thief.getThings(items));
    }

}
