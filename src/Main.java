public class Main {
    public static void main(String[] args) {
        Vertex<String> usa = new Vertex<>("USA");
        Vertex<String> canada = new Vertex<>("Canada");
        Vertex<String> mexico = new Vertex<>("Mexico");
        Vertex<String> brazil = new Vertex<>("Brazil");
        Vertex<String> kazakhstan = new Vertex<>("Kazakhstan");

        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex(usa);
        graph.addVertex(canada);
        graph.addVertex(mexico);
        graph.addVertex(brazil);
        graph.addVertex(kazakhstan);

        usa.addAdjacentVertex(canada, 1.0);
        usa.addAdjacentVertex(mexico, 3.0);
        canada.addAdjacentVertex(mexico, 1.5);
        mexico.addAdjacentVertex(brazil, 4.0);
        brazil.addAdjacentVertex(kazakhstan, 2.0);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(usa);
        System.out.println("BFS path from Kazakhstan to USA:");
        Iterable<Vertex<String>> bfsPath = bfs.pathTo(kazakhstan);
        if (bfsPath != null) {
            for (Vertex<String> vertex : bfsPath) {
                System.out.print(vertex + " ");
            }
        } else {
            System.out.println("No path found.");
        }

        System.out.println();
        System.out.println();

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(usa);
        System.out.println("Dijkstra's path from Kazakhstan to USA:");
        Iterable<Vertex<String>> dijkstraPath = dijkstra.pathTo(kazakhstan);
        if (dijkstraPath != null) {
            for (Vertex<String> vertex : dijkstraPath) {
                System.out.print(vertex + " ");
            }
        } else {
            System.out.println("No path found.");
        }
        System.out.println();
    }
}