## Graph Search Algorithms in Java
This repository contains Java implementations of several graph search algorithms, including Breadth-First Search (BFS) and Dijkstra's Algorithm. It also includes the necessary data structures such as graphs, vertices, and edges, tailored for weighted and unweighted graph scenarios.

## Features
Vertex and Edge Classes: Basic building blocks for graph structures.
WeightedGraph and MyGraph Classes: Support for both weighted and unweighted graphs.
Search Algorithms:
BreadthFirstSearch: Implements BFS for unweighted graphs.
DijkstraSearch: Implements Dijkstra's algorithm for graphs with non-negative weights.
## Getting Started
To use these classes and algorithms in your project, simply clone this repository and include the files in your Java project.

## Prerequisites
Java 11 or higher
## Installing
Clone the repository:
bash
Copy code
git clone https://github.com/your-username/your-repository-name.git
Include the Java files in your project's source directory.
## Usage
Here’s a quick example of how to create a graph, add vertices and edges, and perform a search:

WeightedGraph<String> graph = new WeightedGraph<>();

Vertex<String> a = new Vertex<>("A");
Vertex<String> b = new Vertex<>("B");
Vertex<String> c = new Vertex<>("C");

graph.addVertex(a);
graph.addVertex(b);
graph.addVertex(c);

graph.addEdge(a, b, 1.0);
graph.addEdge(b, c, 2.0);
graph.addEdge(c, a, 3.0);

DijkstraSearch<String> search = new DijkstraSearch<>(a);

Iterable<Vertex<String>> path = search.pathTo(c);
if (path != null) {
    path.forEach(vertex -> System.out.print(vertex + " "));
}
## Contributing
Contributions are welcome! Please feel free to submit pull requests, create issues, or suggest improvements.

## Acknowledgments
Thanks to the Java community for continuous support and inspiration.
