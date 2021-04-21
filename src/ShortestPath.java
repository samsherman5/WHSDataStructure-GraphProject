import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShortestPath {
    public static Map<Character, Integer> dijkstra(Character start, AdjacencyMatrix graph){
        if(!graph.getNodes().contains(start)){
            return null;
        }
        //import nodes into map with pair of (NodeName, Cost)
        Map<Character, Integer> costs = new HashMap<>();
        Set<Character> red = new HashSet<>();
        Set<Character> useableWorkers = new HashSet<>();
        red.add(start);
        useableWorkers.add(start);
        for (Character c : graph.getNodes()){
            costs.put(c, -1);
        }
        costs.replace(start, 0);
        Character working = start;
        while(useableWorkers.size()!=0){
            //Now we loop through the connections that our current node has
            for (Character c : graph.getEdges(working)) {
                //Do not bother trying to relax a completed node
                if(!red.contains(c)) {
                    //Relax node from default or from higher cost
                    if (costs.get(c) == -1 || graph.findEdge(working, c) + costs.get(working) < costs.get(c)) {
                        costs.replace(c, graph.findEdge(working, c)+ costs.get(working));
                    }
                    useableWorkers.add(c);
                }
            }
            //Spend worker
            useableWorkers.remove(working);
            //Find unused worker with the lowest cost
            Pair<Character, Integer> p = new Pair<>(null, -1);
            for(Character c : useableWorkers){
                if(p.getKey()==null || costs.get(c) < p.getValue()){
                    p = new Pair<>(c, costs.get(c));
                }
            }
            //Set worker to the lowest
            working = p.getKey();
            //Complete the new current worker
            red.add(p.getKey());
        }
        return costs;
    }
}
