import java.util.*;

public class ShortestPath {
    public static Map<Character, Integer> dijkstra(Character start, AdjacencyMatrix graph){
        if(!graph.getNodes().contains(start)){
            return null;
        }
        //import nodes into map: Node -> Cost
        Map<Character, Integer> costs = new HashMap<>();
        Set<Character> red = new HashSet<>();
        Set<Character> usableWorkers = new HashSet<>();
        red.add(start);
        usableWorkers.add(start);
        for (Character c : graph.getNodes()){
            costs.put(c, -1);
        }
        costs.replace(start, 0);
        Character working = start;
        while(usableWorkers.size()!=0){
            //Now we loop through the connections that our current node has
            for (Character c : graph.getEdges(working)) {
                //Do not bother trying to relax a completed node
                if(!red.contains(c)) {
                    //Relax node from default or from higher cost
                    if (costs.get(c) == -1 || graph.findEdge(working, c) + costs.get(working) < costs.get(c)) {
                        costs.replace(c, graph.findEdge(working, c)+ costs.get(working));
                    }
                    usableWorkers.add(c);
                }
            }
            //Spend worker
            usableWorkers.remove(working);
            //Find unused worker with the lowest cost
            Map.Entry<Character, Integer> p = new AbstractMap.SimpleEntry<>(null, -1);
            for(Character c : usableWorkers){
                if(p.getKey()==null || costs.get(c) < p.getValue()){
                    p = new AbstractMap.SimpleEntry<>(c, costs.get(c));
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
