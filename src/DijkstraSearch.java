import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final Map<Vertex<V>, Double> distTo = new HashMap<>();
    private final Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();
    private final PriorityQueue<Vertex<V>> pq;

    public DijkstraSearch(Vertex<V> source) {
        super(source);
        pq = new PriorityQueue<>(Comparator.comparingDouble(distTo::get));
        distTo.put(source, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex<V> v = pq.poll();
            for (Vertex<V> w : v.getAdjacentVertices().keySet()) {
                relax(v, w);
            }
        }
    }

    private void relax(Vertex<V> v, Vertex<V> w) {
        double weight = v.getAdjacentVertices().get(w);
        double distThroughV = distTo.get(v) + weight;
        if (distTo.getOrDefault(w, Double.POSITIVE_INFINITY) > distThroughV) {
            distTo.put(w, distThroughV);
            edgeTo.put(w, v);  // Save the path information
            pq.add(w);
        }
    }

    @Override
    public Iterable<Vertex<V>> pathTo(Vertex<V> v) {
        if (!hasPathTo(v)) return null;
        Stack<Vertex<V>> path = new Stack<>();
        for (Vertex<V> x = v; x != source; x = edgeTo.get(x)) {
            path.push(x);
        }
        path.push(source);
        return path;
    }
}
