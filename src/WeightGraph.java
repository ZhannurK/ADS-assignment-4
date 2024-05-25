import java.util.HashMap;
import java.util.Map;

class WeightedGraph<V> {
    private final Map<Vertex<V>, Map<Vertex<V>, Double>> vertices = new HashMap<>();
    private final boolean undirected;

    public WeightedGraph() {
        this.undirected = false;
    }

    public void addVertex(Vertex<V> vertex) {
        vertices.putIfAbsent(vertex, new HashMap<>());
    }

    public void addEdge(Vertex<V> from, Vertex<V> to, double weight) {
        if (!vertices.containsKey(from)) {
            addVertex(from);
        }
        if (!vertices.containsKey(to)) {
            addVertex(to);
        }
        vertices.get(from).put(to, weight);
        if (undirected) {
            vertices.get(to).put(from, weight);  // This line mirrors the edge for undirected graphs
        }
    }
}