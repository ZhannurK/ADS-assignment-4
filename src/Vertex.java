import java.util.Map;

public class Vertex <V> {
    private V data;
    private Map<Vertex<V>, Double> adjacencyList;

    public void setAdjacencyList(Vertex<V> destination, double weight) {
        adjacencyList.put(destination, weight);
    }

    public double getAdjacency(Vertex<V> destination) {
        return adjacencyList.get(destination);
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }
}