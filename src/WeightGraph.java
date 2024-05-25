import java.util.*;

public class WeightGraph <Vertex> {
    private final Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>();
    private final boolean undirected;

    public WeightGraph(){
        this(true);
    }

    public WeightGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex vertex) {
        if (!hasVertex(vertex)) {
            map.put(vertex, new ArrayList<>());
        }
    }

    public void addEdge(Vertex source, Vertex destination, double weight) {
        if(hasVertex(source)){
            addVertex(source);
        }
        if(hasVertex(destination)){
            addVertex(destination);
        }
        if(hasEdge(source, destination, weight)){
            addEdge(source, destination, weight);
        }
        map.get(source).add(new Edge<>(source, destination, weight));
        if(undirected){
           map.get(destination).add(new Edge<>(source, destination, weight));
        }
    }

    public int getVerticesCount(){
        return map.size();
    }

    public int getEdgesCount(){
        int count = 0;
        for(Vertex v : map.keySet()){
            count += map.get(v).size();
        }
        if (undirected){
            count /= 2;
        }
        return count;
    }

    public boolean hasVertex(Vertex vertex){
        return !map.containsKey(vertex);
    }

    public boolean hasEdge(Vertex source, Vertex destination, double weight){
        if(hasVertex(source)){
            return false;
        }
        return map.get(source).contains(new Edge<>(source, destination, weight));
    }

    public List<Edge<Vertex>> adjacentList(Vertex vertex){
        if(hasVertex(vertex)){
            return null;
        }
        List<Edge<Vertex>> vectices = new ArrayList<>();
        for(Edge<Vertex> edge : map.get(vertex)){
            vectices.add(edge);
        }
        return vectices;
    }

    public List<Edge<Vertex>> getEdges(Vertex vertex){
        if(hasVertex(vertex)){
            return null;
        }
        return map.get(vertex);
    }

    public Vertex[] adjacencyList(Vertex currentNode) {
        return null;
    }
}