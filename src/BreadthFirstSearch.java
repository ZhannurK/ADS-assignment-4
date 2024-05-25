import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    private final Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();

    public BreadthFirstSearch(Vertex<V> source) {
        super(source);
        bfs(source);
    }

    private void bfs(Vertex<V> source) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        visited.add(source);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.poll();
            for (Vertex<V> w : v.getAdjacentVertices().keySet()) {
                if (!visited.contains(w)) {
                    visited.add(w);
                    edgeTo.put(w, v);
                    queue.add(w);
                }
            }
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