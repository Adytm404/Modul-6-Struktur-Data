import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class BFSDemo {
    private final List<List<Integer>> adjacencyList;

    BFSDemo(int numVertices) {
        adjacencyList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; ++i) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    void bfs() {
        boolean[] visited = new boolean[adjacencyList.size()];
        Queue<Integer> queue = new ArrayDeque<>();

        visited[1] = true;
        queue.offer(1);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");

            for (int neighbor : adjacencyList.get(currentNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSDemo graph = new BFSDemo(20);

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

        System.out.println("Hasil BFS:");
        graph.bfs();
    }
}
