package lesson7;

import java.util.*;

public class GraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<Vertex>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
    }

    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    public boolean addEdge(int weight, String startLabel, String secondLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = weight;
        return false;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addEdge(int weight, String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(weight, startLabel, secondLabel);

        for (String other : others) {
            result &= addEdge(weight, startLabel, other);
        }

        return result;
    }

    public int getSize() {
        return vertexList.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] > 0) {
                    sb.append(" -> ").append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void display() {
        System.out.println(this);
    }

    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        resetVertexVisited();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
        System.out.println();

    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] > 0 && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        stack.add(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        queue.add(vertex);
        vertex.setVisited(true);
    }

    private void resetVertexVisited() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }


    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        resetVertexVisited();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
        System.out.println();
    }

    public int getMinDistance(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);
        int previousIndex = startIndex;
        int currentIndex = startIndex;
        if (startIndex == -1 || endIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина!");
        }

        Stack<Vertex> stack = new Stack<>();

        resetVertexVisited();

        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        int minDistance = -1;
        int currentDistance = 0;
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != vertexList.get(endIndex) && vertex != null) {
                visitVertex(stack, vertex);
                currentIndex = indexOf(vertex.getLabel());
                currentDistance += adjMatrix[previousIndex][currentIndex];
                previousIndex = currentIndex;
            } else if (vertex == vertexList.get(endIndex)) {
                currentDistance += adjMatrix[previousIndex][endIndex];
                stack.pop();
                minDistance = minDistance > 0 ? Math.min(minDistance, currentDistance) : currentDistance;
                currentDistance = 0;
                previousIndex = startIndex;
            } else {
                stack.pop();
                currentDistance = 0;
                previousIndex = startIndex;
            }
        }

        return minDistance;
    }
}
