import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyGraph<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, List<Vertex>> map = new HashMap<>();

    public MyGraph() {
        this(true);
    }

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex vertex) {
        if (!map.containsKey(vertex)) {
            map.put(vertex, new ArrayList<>());
        }
    }

    public void addEdge(Vertex source, Vertex destination) {
        if (!hasVertex(source)) {
            addVertex(source);
        }
        if (!hasVertex(destination)) {
            addVertex(destination);
        }
        if (!hasEdge(source, destination)) {
            map.get(source).add(destination);
            if (undirected) {
                map.get(destination).add(source);
            }
        }
    }

    public int getVertexCount() {
        return map.size();
    }

    public int getEdgeCount() {
        int count = 0;
        for (List<Vertex> vertexList : map.values()) {
            count += vertexList.size();
        }
        if (undirected) {
            count /= 2;
        }
        return count;
    }

    public boolean hasVertex(Vertex vertex) {
        return map.containsKey(vertex);
    }

    public boolean hasEdge(Vertex source, Vertex destination) {
        if (!hasVertex(source)) {
            return false;
        }
        return map.get(source).contains(destination);
    }

    public Iterable<Vertex> adjacencyList(Vertex source) {
        if (!hasVertex(source)) {
            return null;
        }
        return map.get(source);
    }
}