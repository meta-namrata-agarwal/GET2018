/**
 * 
 * @author Namrata Agarwal
 *
 */
public class Edge implements Comparable<Edge> {
    private int source;
    private int destination;
    private int weight;

    public Edge(int source, int destination, int weight) {

        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    /**
     * @return the source
     */
    public int getSource() {
        return source;
    }

    /**
     * @param source
     *            the source to set
     */
    public void setSource(int source) {
        this.source = source;
    }

    /**
     * @return the destination
     */
    public int getDestination() {
        return destination;
    }

    /**
     * @param destination
     *            the destination to set
     */
    public void setDestination(int destination) {
        this.destination = destination;
    }

    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight
     *            the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge) {
        // TODO Auto-generated method stub
        return this.getWeight() - edge.getWeight();
    }

}
