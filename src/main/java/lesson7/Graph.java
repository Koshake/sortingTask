package lesson7;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(int weight, String startLabel, String secondLabel, String... others);
    boolean addEdge(int weight, String startLabel, String secondLabel);

    int getSize();

    void display();

    void dfs(String startLabel);

    void bfs(String startLabel);

    int getMinDistance(String startLabel, String endLabel);
}
