public class Main {
    public static void main(String[] args) {
        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");

        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge(a, b, 1.0);
        graph.addEdge(b, c, 2.0);
        graph.addEdge(c, a, 3.0);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(a);
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(a);

        // Check and print BFS path
        Iterable<Vertex<String>> bfsPath = bfs.pathTo(c);
        if (bfsPath != null) {
            for (Vertex<String> v : bfsPath) {
                System.out.println(v.getData());
            }
        } else {
            System.out.println("No path found (BFS) from A to C");
        }

        // Check and print Dijkstra's path
        Iterable<Vertex<String>> dijkstraPath = dijkstra.pathTo(c);
        if (dijkstraPath != null) {
            for (Vertex<String> v : dijkstraPath) {
                System.out.println(v.getData());
            }
        } else {
            System.out.println("No path found (Dijkstra) from A to C");
        }
    }
}
