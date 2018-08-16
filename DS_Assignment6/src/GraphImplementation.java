import java.util.*;

/**
 * graph implementation
 * 
 * @author Namrata Agarwal
 *
 */
public class GraphImplementation implements UndirectedWeightedGraph {

    private List<Integer>[] adjacencyMatrix;
    private int vertices;
    private List<Edge> edgeList;
    List<Integer> reachNode;

    @SuppressWarnings("unchecked")
    public GraphImplementation(int vertices) {

        this.vertices = vertices;
        adjacencyMatrix = new LinkedList[vertices];
        edgeList = new LinkedList<Edge>();
        for (int i = 0; i < vertices; i++) {
            adjacencyMatrix[i] = new LinkedList<Integer>();
        }
    }

    /**
     * method to add edges to the graph
     * 
     * @param source
     * @param destination
     * @param weight
     */
    public void createGraph(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencyMatrix[source].add(destination);
        adjacencyMatrix[destination].add(source);
        edgeList.add(edge);
    }

    /**
     * method to check whether graph is connected or not
     */
    @Override
    public boolean isConnected() {
        reachNode = new LinkedList<>();
        return DFS(3);
    }

    /**
     * method to return all reachable nodes
     */
    @Override
    public List<Integer> reachable(int vertex) {
        reachNode = new LinkedList<>();
        DFS(vertex);
        System.out.println();
        return reachNode;
    }

    /**
     * private method for DFS
     * 
     * @param sourceVertices
     * @return
     */
    private boolean DFS(int sourceVertices) {
        boolean visited[] = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            visited[i] = false;
        }
        DFSUtility(sourceVertices, visited);
        for (int i = 0; i < vertices; i++) {
            if (visited[i] == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * helper method for DFS
     * 
     * @param source
     * @param visited
     */
    private void DFSUtility(int source, boolean visited[]) {
        System.out.println(source);
        reachNode.add(source);
        visited[source] = true;
        Iterator<Integer> edgeIterator = adjacencyMatrix[source].listIterator();
        while (edgeIterator.hasNext()) {
            int vertex = edgeIterator.next();
            if (!visited[vertex])
                DFSUtility(vertex, visited);
        }
    }

    /**
     * method to find the mst by prims algorithm
     */
    @Override
    public List<Edge> mst() {
        Set<Integer> visitedVertexSet = new HashSet<Integer>();
        List<Edge> listOfVisitedEdge = new ArrayList<Edge>();
        Collections.sort(edgeList);
        if (edgeList.size() <= 0) {
            throw new AssertionError("there are no edges in graph");
        } else {
            listOfVisitedEdge.add(edgeList.get(0));
            visitedVertexSet.add(edgeList.get(0).getSource());
            visitedVertexSet.add(edgeList.get(0).getDestination());

            int i = 1;
            while (visitedVertexSet.size() != vertices && i < edgeList.size()) {
                Edge edge = edgeList.get(i);
                if ((!visitedVertexSet.contains(edge.getSource()))
                        || (!visitedVertexSet.contains(edge.getDestination()))) {
                    listOfVisitedEdge.add(edge);
                    visitedVertexSet.add(edge.getSource());
                    visitedVertexSet.add(edge.getDestination());
                } else {
                    if ((visitedVertexSet.contains(edge.getSource()))
                            && (visitedVertexSet.contains(edge.getDestination()))) {
                        if (!(isCycle(listOfVisitedEdge, edge))) {
                            listOfVisitedEdge.add(edge);
                            visitedVertexSet.add(edge.getSource());
                            visitedVertexSet.add(edge.getDestination());
                        }
                    }

                }

                i++;
            }
        }
        if (visitedVertexSet.size() != vertices) {
            throw new AssertionError("spanning tree not possible");
        }
        return listOfVisitedEdge;
    }

    /**
     * check whether there is cycle in graph or not
     * 
     * @param visitedEdges
     *            is a list of visited edges
     * @param edge
     *            is an edge
     * @return
     */
    private boolean isCycle(List<Edge> visitedEdges, Edge edge) {
        int startVertex = edge.getSource();
        List<Edge> tempList = new ArrayList<Edge>();
        for (Edge graphEdge : visitedEdges) {
            tempList.add(graphEdge);
        }
        while (startVertex != edge.getDestination()) {
            if (startVertex == -1) {
                return false;
            }
            int endVertex = findEndVertex(tempList, startVertex);
            startVertex = endVertex;
        }
        if (startVertex == edge.getDestination()) {
            return true;
        }
        return false;
    }

    /**
     * find vertex corresponding to start vertex
     * 
     * @param tempList
     *            is a list of visited edges
     * @param startVertex
     *            is a vertex
     * @return end vertex
     */
    private int findEndVertex(List<Edge> tempList, int startVertex) {
        for (int i = 0; i < tempList.size(); i++) {
            if (tempList.get(i).getSource() == startVertex) {
                int vertex = tempList.get(i).getDestination();
                tempList.remove(i);
                return vertex;

            } else {
                if (tempList.get(i).getDestination() == startVertex) {
                    int vertex = tempList.get(i).getSource();
                    tempList.remove(i);
                    return vertex;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        GraphImplementation g = new GraphImplementation(4);
        g.createGraph(0, 1, 4);
        // g.createGraph(0, 2, 3);
        g.createGraph(2, 1, 5);
        g.createGraph(2, 3, 7);
        // g.createGraph(1, 3, 2);
        System.out.println(g.isConnected());
        System.out.println(g.reachable(2));

        List<Edge> list = g.mst();
        for (Edge e : list) {
            System.out.println(e.getSource() + " " + e.getDestination() + " " + e.getWeight());
        }

    }

    @Override
    public int shortestPath(int vertex1, int vertex2) {
        // TODO Auto-generated method stub
        return 0;
    }

}
