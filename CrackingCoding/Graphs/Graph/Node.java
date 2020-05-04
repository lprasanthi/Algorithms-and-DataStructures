package Graph;
import java.util.*;
public class Node {
    public int data;
    public List<Node> children;
    public Node(){
        
    }
    public Node(int data){
        this.data = data;
        children = new ArrayList<Node>();
    }
    public void addEdge(Node child){
        children.add(child);
    }
}