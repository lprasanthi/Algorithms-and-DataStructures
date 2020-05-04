package Graph;
import java.util.*;
import Graph.*;
public class UnDirectedGraph{
    List<Node> vertices;
    public UnDirectedGraph() {
        vertices = new ArrayList<Node>();
    }
    public void addEdge(Node start, Node end){
        start.addEdge(end);
        end.addEdge(start);
    }
    public void addEdge(NodeVisited start, NodeVisited end){
        start.addEdge(end);
        end.addEdge(start);
    }
}