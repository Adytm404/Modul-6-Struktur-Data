import java.util.*;

public class GraphTraversalDemo {
    private List<List<Integer>> adjacencyList;

    public GraphTraversalDemo(int numVertices) {
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

    public void bfs() {
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
        Scanner scanner = new Scanner(System.in);
        GraphTraversalDemo graph = new GraphTraversalDemo(20);

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

        boolean exitProgram = false;

        while (!exitProgram) {
            System.out.println("=== PILIH METODE ===");
            System.out.println("1. DFS");
            System.out.println("2. BFS");
            System.out.println("3. Exit");

            System.out.print("Masukkan pilihan: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Hasil DFS:");
                    graph.dfs(1);
                    break;
                case 2:
                    System.out.println("Hasil BFS:");
                    graph.bfs();
                    break;
                case 3:
                    exitProgram = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }

            if (!exitProgram) {
                System.out.println("\n=== MENU ===");
                System.out.println("1. Kembali ke menu");
                System.out.println("2. Exit");

                System.out.print("Masukkan pilihan: ");
                int menuChoice = scanner.nextInt();

                switch (menuChoice) {
                    case 1:
                        break;
                    case 2:
                        exitProgram = true;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Program akan keluar.");
                        exitProgram = true;
                        break;
                }
            }
        }
    }
}
