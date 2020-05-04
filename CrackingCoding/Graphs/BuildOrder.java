import Graph.NodeVisited;
import Graph.Node;
import Graph.DirectedGraph;
import java.util.*;
public class BuildOrder{
    public static DirectedGraph<NodeVisited> constructGraph(char[] projects, char[][] dependencies){
        DirectedGraph<NodeVisited> graph= new DirectedGraph<NodeVisited>();
        for(int i=0; i<projects.length;i++){
            NodeVisited n = new NodeVisited(projects[i]);
            graph.addVertex(n);
        }
        for(int i=0; i<dependencies.length;i++){
            NodeVisited end = graph.get(dependencies[i][0]);
            NodeVisited start = graph.get(dependencies[i][1]);
            // handle null scenarios
            graph.addEdge(start,end);
        }
        return graph;
    }
    private static boolean findBuildOrderHelper(NodeVisited current, List<Character> buildOrder){
        boolean isAvailable;
        if(current.visited == true){
            return true;
        } else if(current.visiting == true)
            return false;
        current.visiting = true;
        for(NodeVisited node : current.children){
            if(node.visiting == true)
                return false;
            else if(node.visited == false){
                isAvailable = findBuildOrderHelper(node,buildOrder);
                if(!isAvailable)
                    return false;
            }
        }
        current.visiting = false;
        current.visited = true;
        buildOrder.add(current.cdata);
        return true;
    }
    
    public static List<Character> findBuildOrder(DirectedGraph<NodeVisited> g){
        List<Character> buildOrder = new ArrayList<Character>();
        boolean isAvailable = true;
        while(isAvailable && buildOrder.size() != g.size()){
            NodeVisited current = g.next();
            while(current != null && current.visited == true){
               current = g.next(); 
            }
            isAvailable = findBuildOrderHelper(current, buildOrder);
        }
        if(isAvailable)
            return buildOrder;
        return new ArrayList<Character>();
    }
    public static findBuildOrder(char[] projects, char[][] dependencies){
        DirectedGraph<NodeVisited> graph = constructGraph(projects,dependencies);
        return findBuildOrder(graph);
    }
    public static void main(String[] args) {
        char[] projects = {'a','b','c','d','e','f'};
        char[][] dependencies = {{'a','d'},{'f','b'},{'b','d'},{'f','a'},{'d','c'}};
        List<Character> buildOrder = findBuildOrder(projects, dependencies);
        for(int i=0; i<buildOrder.size();i++){
           System.out.println(buildOrder.get(i)); 
        }
    }
}