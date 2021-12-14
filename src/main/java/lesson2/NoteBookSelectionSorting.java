package lesson2;

public class NoteBookSelectionSorting implements SortingStrategy {
    public void sort(NoteBook[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minN = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].price < array[minN].price) {
                    minN = j;
                } else if (array[j].price == array[minN].price
                        && array[j].memory < array[minN].memory) {
                    minN = j;
                } else if (array[j].memory == array[minN].memory
                        && array[j].price == array[minN].price
                        && array[j].model.ordinal() < array[minN].model.ordinal()
                ) {
                    minN = j;
                }
            }
            swap(array, i, minN);
        }
    }

    static void swap(NoteBook[] a, int i, int change) {
        NoteBook temp = a[i];
        a[i] = a[change];
        a[change] = temp;
    }
}
