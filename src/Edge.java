import java.util.Objects;

public class Edge <Vertex> {
    private Vertex source;
    private Vertex destination;
    private Double weight;

    public Edge(Vertex source, Vertex destination, Double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public Double getWeight() {
        return weight;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // references compared

        if (o == null || getClass() != o.getClass()) return false;

        Edge<?> otherEdge = (Edge<?>) o;

        return Objects.equals(this.source, otherEdge.source) &&
                Objects.equals(this.destination, otherEdge.destination);
    }
}