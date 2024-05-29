public class Main {
    public static void main(String[] args) {
        // Create vertices
        Vertex<String> v1 = new Vertex<>("A");
        Vertex<String> v2 = new Vertex<>("B");
        Vertex<String> v3 = new Vertex<>("C");
        Vertex<String> v4 = new Vertex<>("D");
        Vertex<String> v5 = new Vertex<>("E");

        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge(v1, v2, 1);
        graph.addEdge(v1, v3, 1);
        graph.addEdge(v2, v4, 1);
        graph.addEdge(v3, v4, 1);
        graph.addEdge(v4, v5, 1);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(v1);
        System.out.println("BFS path from A to E:");
        Iterable<Vertex<String>> bfsPath = bfs.pathTo(v5);
        if (bfsPath != null) {
            for (Vertex<String> vertex : bfsPath) {
                System.out.print(vertex.getData() + " ");
            }
        } else {
            System.out.println("No path found");
        }
        System.out.println();

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(v1);
        System.out.println("Dijkstra path from A to E:");
        Iterable<Vertex<String>> dijkstraPath = dijkstra.pathTo(v5);
        if (dijkstraPath != null) {
            for (Vertex<String> vertex : dijkstraPath) {
                System.out.print(vertex.getData() + " ");
            }
        } else {
            System.out.println("No path found");
        }
    }
}