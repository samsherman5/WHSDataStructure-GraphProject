import java.util.ArrayList;

public class AMTest {
    public static void main(String[] args) {
        AdjacencyMatrix am = new AdjacencyMatrix();
        am.addNode('A');
        am.addNode('B');
        am.addNode('C');
        am.addNode('D');
        am.addNode('E');
        am.addNode('F');
        am.addNode('G');
        am.addNode('H');
        am.addEdge('A', 'B', 5);
        am.addEdge('A', 'D', 3);
        am.addEdge('A', 'C', 7);
        am.addEdge('C', 'G', 1);
        am.addEdge('G', 'H', 6);
        am.addEdge('H', 'D', 11);
        am.addEdge('H', 'E', 9);
        am.addEdge('H', 'F', 4);
        am.addEdge('B', 'E', 2);
        am.addEdge('B', 'F', 10);

        System.out.println(am.nodes);
        for(ArrayList<Integer> e : am.edges){
            System.out.println(e);
        }
    }
}
