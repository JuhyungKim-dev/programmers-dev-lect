import java.util.LinkedList;

class DFSGraph {
    private LinkedList<Integer>[] adjacencyList;
    public DFSGraph(int vertex) {
        adjacencyList = new LinkedList[vertex + 1];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
        adjacencyList[w].add(v);
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[adjacencyList.length];
        System.out.println("정점 " + start + "에서 시작하는 DFS");
        dfsRecursive(start, visited);
        System.out.println();
    }

    private void dfsRecursive(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int adj : adjacencyList[vertex]) {
            if (!visited[adj]) {
                dfsRecursive(adj, visited);
            }
        }
    }
}

public class task2_2_0616_DFS {
    public static void main(String[] args) {
        DFSGraph graph = new DFSGraph(9);
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
        graph.dfs(1);
    }
}