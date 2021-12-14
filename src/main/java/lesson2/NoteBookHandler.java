package lesson2;

public class NoteBookHandler {

    NoteBook [] array;
    SortingStrategy strategy;

    NoteBookHandler(NoteBook[] noteBookArray, SortingStrategy sortStrategy) {
        array = noteBookArray;
        strategy = sortStrategy;
    }

    public void sortNoteBooks() {
        strategy.sort(array);
    }
}
