package lesson2;

import java.util.Random;

public class MyNoteBookArray {
    private static final Random random = new Random();
    public static boolean isShuffle = false;

    public static NoteBook[] getArray(int length) {
        NoteBook[] arr = new NoteBook[length];
        final int diffPrice = 50;
        final int maxPrice = 2000;
        final int minPrice = 500;
        final int diffMemory = 4;
        final int maxMemory = 24;
        final int minMemory = 4;
        for (int i = 0; i < length; i++) {
            arr[i] = new NoteBook(
                    diffPrice * random.nextInt((maxPrice + diffPrice - minPrice) / diffPrice) + minPrice,
                    diffMemory * random.nextInt((maxMemory + diffMemory - minMemory) / diffMemory) + minMemory,
                    NoteBookModel.values()[random.nextInt(NoteBookModel.values().length)]
            );
        }
        if (isShuffle) {
            shuffleArray(arr);
        }
        return arr;
    }


    public static void shuffleArray(NoteBook[] arr) {
        if (!isShuffle) {
            return;
        }
        int n = arr.length;
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(arr, i, change);
        }
    }

    private static void swap(NoteBook[] a, int i, int change) {
        NoteBook temp = a[i];
        a[i] = a[change];
        a[change] = temp;
    }
}
