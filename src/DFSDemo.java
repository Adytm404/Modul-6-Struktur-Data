import java.util.ArrayList;
import java.util.List;

public class DFSDemo {
    private List<List<Integer>> adjacencyList;

    public DFSDemo(int numVertices) {
        adjacencyList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    public void dfs(int startVertex) {
        boolean[] visited = new boolean[adjacencyList.size()];
        dfsUtil(startVertex, visited);
    }

    private void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFSDemo graph = new DFSDemo(20);

        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 1);
        graph.addEdge(5, 2);
        graph.addEdge(5, 3);
        graph.addEdge(5, 9);
        graph.addEdge(5, 7);
        graph.addEdge(9, 5);
        graph.addEdge(9, 8);
        graph.addEdge(4, 6);
        graph.addEdge(6, 7);
        graph.addEdge(4, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 6);
        graph.addEdge(7, 11);
        graph.addEdge(8, 9);
        graph.addEdge(8, 11);
        graph.addEdge(11, 7);
        graph.addEdge(11, 10);

        System.out.println("Hasil DFS:");
        graph.dfs(1);
    }
}
