import java.util.HashSet;
import java.util.Set;

public abstract class Search<V> {
    protected Set<Vertex<V>> visited = new HashSet<>();
    protected Vertex<V> source;

    public Search(Vertex<V> source) {
        this.source = source;
    }

    public boolean hasPathTo(Vertex<V> v) {
        return visited.contains(v);
    }

    public abstract Iterable<Vertex<V>> pathTo(Vertex<V> v);
}