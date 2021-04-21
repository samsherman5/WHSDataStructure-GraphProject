import java.util.Map;

public class GraphTest {
    public static void main(String[] args) {
        int [] [] am1 = {
                { -1,  2,  4, -1, -1, -1 },
                { -1, -1,  1,  7, -1, -1 },
                { -1, -1, -1, -1,  3, -1 },
                { -1, -1, -1, -1, -1,  1 },
                { -1, -1, -1,  2, -1,  5 },
                { -1, -1, -1, -1, -1, -1 }
        };
        int [] [] am2 = {
                { -1, 50, 45, 10, -1, -1 },
                { -1, -1, 10, 15, -1, -1 },
                { -1, -1, -1, -1, 30, -1 },
                { 10, -1, -1, -1, 15, -1 },
                { -1, 20, 35, -1, -1, -1 },
                { -1, -1, -1, -1,  3, -1 }
        };
        int [] [] am3 = {
                // 0     1    2    3    4    5    6    7     8    9
                { -1,  -1,   3,  -1,  -1,   2,  -1,  -1,  -1,  -1 },
                { -1,  -1,  -1,  -1,   5,  -1,  -1,  -1,  -1,   6 },
                {  3,  -1,  -1,   3,  -1,  -1,   1,  -1,  -1,  -1 },
                { -1,  -1,   3,  -1,   4,  -1,   8,  -1,  -1,  -1 },
                { -1,   5,  -1,   4,  -1,  -1,  -1,   3,  -1,  -1 },
                {  2,  -1,  -1,  -1,  -1,  -1,   4,  -1,   5,  -1 },
                { -1,  -1,   1,   8,  -1,   4,  -1,   6,   7,  -1 },
                { -1,  -1,  -1,  -1,   3,  -1,   6,  -1,  -1,   1 },
                { -1,  -1,  -1,  -1,  -1,   5,   7,  -1,  -1,   2 },
                { -1,   6,  -1,  -1,  -1,  -1,  -1,   1,   2,  -1 }
        };
        AdjacencyMatrix am = new AdjacencyMatrix(am1, true);
        AdjacencyMatrix a2 = new AdjacencyMatrix(am2, true);
        AdjacencyMatrix a3 = new AdjacencyMatrix(am3, true);
        Map<Character, Integer> output1 = ShortestPath.dijkstra('0', am);
        Map<Character, Integer> output2 = ShortestPath.dijkstra('0', a2);
        Map<Character, Integer> output3 = ShortestPath.dijkstra('0' , a3);
        System.out.println("Graph #1");
        output1.forEach((key, value) -> System.out.println("Node: " + key + " Cost: " + value));
        System.out.println("\nGraph #2");
        output2.forEach((key, value) -> System.out.println("Node: " + key + " Cost: " + value));
        System.out.println("\nGraph #3");
        output3.forEach((key, value) -> System.out.println("Node: " + key + " Cost: " + value));


    }
}
