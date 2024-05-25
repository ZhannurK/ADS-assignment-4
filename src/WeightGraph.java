import java.util.HashMap;
import java.util.Map;

class WeightedGraph<V> {
    private final Map<Vertex<V>, Map<Vertex<V>, Double>> vertices = new HashMap<>();

    public void addVertex(Vertex<V> vertex) {
        vertices.putIfAbsent(vertex, new HashMap<>());
    }

    public void addEdge(Vertex<V> from, Vertex<V> to, double weight) {
        addVertex(from);
        addVertex(to);
        vertices.get(from).put(to, weight);
        vertices.get(to).put(from, weight);  // For undirected graph, remove this line for directed graph
    }

    public Map<Vertex<V>, Map<Vertex<V>, Double>> getVertices() {
        return vertices;
    }
}