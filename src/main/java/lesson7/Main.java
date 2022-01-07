package lesson7;

public class Main {
    public static void main(String[] args) {
        //testGraph();
        //testBfs();
        //testDfs();

        testDistance();
    }

    private static void testGraph() {

        Graph graph = new GraphImpl(7);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge(1, "A", "B", "C");
        graph.addEdge(1, "B", "C", "D");
        graph.addEdge(1, "C", "A", "B", "D");
        graph.addEdge(1, "D", "B", "C");

        System.out.println("Size of graph is " + graph.getSize());
        graph.display();
    }

    private static void testDfs() {
        Graph graph = new GraphImpl(7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge(1, "A", "B", "C", "D");
        graph.addEdge(1, "B", "E");

        graph.addEdge(1, "E", "D");

        graph.addEdge(1, "D", "F");
        graph.addEdge(1, "F", "G");

        graph.addEdge(1, "G", "D");

        graph.dfs("A");

        graph.display();
    }

    private static void testBfs() {
        Graph graph = new GraphImpl(8);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdge(1, "A", "B", "C", "D");
        graph.addEdge(1, "B", "E");
        graph.addEdge(1, "E", "H");
        graph.addEdge(1, "C", "F");
        graph.addEdge(1, "D", "G");

        graph.bfs("A");
    }

    private static void testDistance() {
        Graph graph = new GraphImpl(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");


        graph.addEdge(1, "Москва", "Тула");
        graph.addEdge(1, "Москва", "Рязань");
        graph.addEdge(1, "Москва", "Калуга");

        graph.addEdge(2, "Тула", "Липецк");
        graph.addEdge(3, "Липецк", "Воронеж");

        graph.addEdge(3, "Рязань", "Тамбов");
        graph.addEdge(4, "Тамбов", "Саратов");
        graph.addEdge(2, "Саратов", "Воронеж");

        graph.addEdge(4, "Калуга", "Орел");
        graph.addEdge(2, "Орел", "Курск");
        graph.addEdge(6, "Курск", "Воронеж");


        System.out.println("Size of graph is " + graph.getSize());
        graph.display();

        //graph.dfs("Москва");
        System.out.println("Min distance: " + graph.getMinDistance("Москва", "Воронеж"));

    }
}
