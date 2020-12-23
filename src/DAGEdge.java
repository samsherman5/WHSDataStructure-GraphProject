public class DAGEdge {
    final int to;
    final int from;
    final int cost;

    public DAGEdge(int to, int from, int cost){
        this.to = to;
        this.from = from;
        this.cost = cost;
    }

    public String toString(){
        return to + " " + from + " " + cost;
    }
}
