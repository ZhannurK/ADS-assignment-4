public class Main {
    public static void main(String[] args) {
        // Create vertices
        Vertex<String> usa = new Vertex<>("USA");
        Vertex<String> canada = new Vertex<>("Canada");
        Vertex<String> mexico = new Vertex<>("Mexico");
        Vertex<String> brazil = new Vertex<>("Brazil");
        Vertex<String> argentina = new Vertex<>("Kazakhstan");

        // Create a weighted graph
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex(usa);
        graph.addVertex(canada);
        graph.addVertex(mexico);
        graph.addVertex(brazil);
        graph.addVertex(argentina);

        // Add edges
        usa.addAdjacentVertex(canada, 1.0);
        usa.addAdjacentVertex(mexico, 4.0);
        canada.addAdjacentVertex(mexico, 1.5);
        mexico.addAdjacentVertex(brazil, 3.0);
        brazil.addAdjacentVertex(argentina, 2.0);

        // Perform BFS
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(usa);
        System.out.println("BFS path from USA to Kazakhstan:");
        Iterable<Vertex<String>> bfsPath = bfs.pathTo(argentina);
        if (bfsPath != null) {
            for (Vertex<String> vertex : bfsPath) {
                System.out.print(vertex + " ");
            }
        } else {
            System.out.println("No path found.");
        }

        System.out.println();

        // Perform Dijkstra's algorithm
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(usa);
        System.out.println("Dijkstra's path from USA to Kazakhstan:");
        Iterable<Vertex<String>> dijkstraPath = dijkstra.pathTo(argentina);
        if (dijkstraPath != null) {
            for (Vertex<String> vertex : dijkstraPath) {
                System.out.print(vertex + " ");
            }
        } else {
            System.out.println("No path found.");
        }
    }
}