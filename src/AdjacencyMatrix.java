import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdjacencyMatrix {
    int index = 0;
    public Map<Character, Integer> nodes;
    public ArrayList<ArrayList<Integer>> edges;

    public AdjacencyMatrix(){
        nodes = new HashMap<>();
        edges = new ArrayList<>();
    }

    public void addNode(Character c){
        if(nodes.containsKey(c)) return;
        nodes.put(c, index++);
        edges.add(new ArrayList<>());
        for (int i = 0; i < edges.size(); i++) {
            edges.get(edges.size()-1).add(-1);
            edges.get(i).add(-1);
        }
    }

    public void addEdge(Character a, Character b, int cost){
        if(!nodes.containsKey(a) || !nodes.containsKey(b)) return;
        int i1 = nodes.get(a);
        int i2 = nodes.get(b);
        edges.get(i1).set(i2, cost);
        edges.get(i2).set(i1, cost);
    }

    public int findEdge(Character a, Character b){
        if(!nodes.containsKey(a) || !nodes.containsKey(b)) return -1;
        int i1 = nodes.get(a);
        int i2 = nodes.get(b);
        return edges.get(i1).get(i2);
    }
}