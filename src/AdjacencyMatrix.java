import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrix{
    public ArrayList<Character> nodes;
    public ArrayList<ArrayList<Integer>> edges;
    private final boolean directed;

    public AdjacencyMatrix(){
        this(false);
    }

    public AdjacencyMatrix(boolean directed){
        this.directed = directed;
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public AdjacencyMatrix(int[][]am, boolean directed){
        this.directed = directed;
        this.nodes = new ArrayList<>();
        for (int i = 0; i < am.length; i++) {
            nodes.add(Integer.toString(i).charAt(0));
        }
        this.edges = new ArrayList<>();
        for (int i = 0; i < am.length; i++) {
            edges.add(new ArrayList<>());
            for (int j = 0; j < am.length; j++) {
                edges.get(i).add(am[i][j]);
            }
        }
    }

    public List<Character> getNodes(){
        return this.nodes;
    }

    public void addNode(Character c){
        if(nodes.contains(c)) return;
        nodes.add(c);
        edges.add(new ArrayList<>());
        for (int i = 0; i < edges.size(); i++) {
            edges.get(nodes.size()-1).add(-1);
        }
        for (int i = 0; i < edges.size()-1; i++) {
            edges.get(i).add(-1);
        }
    }

    public List<Character> getEdges(Character c){
        List<Character> out = new ArrayList<Character>();
        if(!nodes.contains(c)) return null;
        ArrayList<Integer> tem = edges.get(nodes.indexOf(c));
        for (int i = 0; i < tem.size(); i++) {
            if(!tem.get(i).equals(-1)) {
                out.add(nodes.get(i));
            }
        }
        return out;
    }

    public void addEdge(Character a, Character b, int cost){
        if(!nodes.contains(a) || !nodes.contains(b)) return;
        int i1 = nodes.indexOf(a);
        int i2 = nodes.indexOf(b);
        edges.get(i1).set(i2, cost);
        if(!directed)
            edges.get(i2).set(i1, cost);
    }

    public int findEdge(Character a, Character b){
        if(!nodes.contains(a) || !nodes.contains(b)) return -1;
        int i1 = nodes.indexOf(a);
        int i2 = nodes.indexOf(b);
        return edges.get(i1).get(i2);
    }
}