import java.util.List;

/**
 * 
 * @author Namrata Agarwal
 *
 */
public interface UndirectedWeightedGraph {

    boolean isConnected();

    List<Integer> reachable(int vertex);

    List<Edge> mst();

    int shortestPath(int vertex1, int vertex2);
}
