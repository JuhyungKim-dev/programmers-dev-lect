import java.util.*;

class BFSGraph {
    private LinkedList<Integer>[] adjacencyList;

    public BFSGraph(int vertex) {
        adjacencyList = new LinkedList[vertex + 1];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
        adjacencyList[w].add(v);
    }

    public void printGraph() {
        for (int i = 1; i < adjacencyList.length; i++) {
            System.out.print("Vertex " + i + " : ");
            for (Integer v : adjacencyList[i]) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public LinkedList<Integer>[] getAdjacencyList() {
        return adjacencyList;
    }
}

public class task2_1_0616_BFS {
    public static void main(String[] args) {
        BFSGraph graph = new BFSGraph(9);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 6);
        graph.addEdge(3, 7);
        graph.addEdge(4, 5);
        graph.addEdge(4, 7);
        graph.addEdge(4, 8);
        graph.addEdge(5, 6);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);
        graph.printGraph();

        boolean[] visited = new boolean[9 + 1];
        int startVertex = 1;
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);
        System.out.println();
        System.out.println("정점 " + startVertex + "에서 시작하는 BFS");

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for (int adj : graph.getAdjacencyList()[vertex]) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }
}

