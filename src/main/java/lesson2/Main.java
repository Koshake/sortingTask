package lesson2;


public class Main {
    public static void main(String[] args) {

        MyNoteBookArray.isShuffle = true;
        final int SIZE = 10000;
        NoteBook[] arr = MyNoteBookArray.getArray(SIZE);
        NoteBookHandler handler = new NoteBookHandler(arr, new NoteBookSelectionSorting());
        handler.sortNoteBooks();
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Price: " + arr[i].price + " mem: " + arr[i].memory + " Model: " + arr[i].model);
        }
    }
}
