public class DAGTester {
    public static void main(String[] args) {
        DAG dag = new DAG();
        dag.addNode('A');
        dag.addNode('B');
        dag.addNode('C');
        dag.addNode('D');
        dag.addNode('E');
        dag.addNode('F');
        dag.addNode('G');
        dag.addNode('H');
        dag.addEdge('A', 'B', 5);
        dag.addEdge('A', 'D', 3);
        dag.addEdge('A', 'C', 7);
        dag.addEdge('C', 'G', 1);
        dag.addEdge('G', 'H', 6);
        dag.addEdge('H', 'D', 11);
        dag.addEdge('H', 'E', 9);
        dag.addEdge('H', 'F', 4);
        dag.addEdge('B', 'E', 2);
        dag.addEdge('B', 'F', 10);

        System.out.println(dag.nodes);
        System.out.println(dag.edges);
    }
}
