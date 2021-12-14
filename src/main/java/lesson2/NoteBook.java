package lesson2;

public class NoteBook {
    int price;
    int memory;
    NoteBookModel model;

    public NoteBook(int price, int memory, NoteBookModel model) {
        this.model = model;
        this.price = price;
        this.memory = memory;
    }
}

enum NoteBookModel {
    Lenuvo,
    Asos,
    MacNote,
    Eser,
    Xamiou,
}