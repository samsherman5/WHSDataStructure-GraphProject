import java.util.ArrayList;
import java.util.List;

public class DAG {
    public List<Character> nodes;
    public List<DAGEdge> edges;

    public DAG(){
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addNode(Character c){
        if(nodes.contains(c)){
            return;
        }
        nodes.add(c);
    }

    public void addEdge(Character a, Character b, int cost){
        if(!nodes.contains(a) || !nodes.contains(b)){
            return;
        }
        for (DAGEdge edge : edges) {
            if((edge.to == a || edge.to == b) && (edge.from == b || edge.from == a)){
                return;
            }
        }
        edges.add(new DAGEdge(nodes.indexOf(a), nodes.indexOf(b), cost));
    }

    public int findEdge(Character a, Character b){
        int index = -1;
        for (int i = 0; i < edges.size(); i++) {
            if((nodes.get(edges.get(i).to) == a || nodes.get(edges.get(i).to) == b) &&
                    (nodes.get(edges.get(i).from) == b || nodes.get(edges.get(i).from) == a)){
                index = edges.get(i).cost;
                break;
            }
        }
        return index;
    }
}
