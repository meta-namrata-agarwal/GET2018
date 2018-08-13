import java.util.List;


public interface UndirectedWeightedGraph {

    boolean isConnected();

    List<Integer> reachable(int vertex);

   

    List<Edge> mst();

}
