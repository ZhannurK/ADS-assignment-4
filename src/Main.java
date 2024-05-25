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

        for (Vertex<String> v : bfs.pathTo(c)) {
            System.out.println(v.getData());
        }

        for (Vertex<String> v : dijkstra.pathTo(c)) {
            System.out.println(v.getData());
        }
    }
}