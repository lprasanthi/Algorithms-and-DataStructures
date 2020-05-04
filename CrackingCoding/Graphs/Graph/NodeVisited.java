package Graph;
import java.util.*;
public class NodeVisited extends Node {
    public boolean visited;
    public boolean visiting;
    public List<NodeVisited> children;
    public char cdata;
    public NodeVisited(int data){
        this.data = data;
        children = new ArrayList<NodeVisited>();
        visited= false;
        visiting=false;
    }
    public NodeVisited(char cdata){
        this.cdata = cdata;
        children = new ArrayList<NodeVisited>();
        visited= false;
        visiting=false;
    }
    public boolean isVisited(){
        return visited;
    }
    public void visited(boolean visited){
        this.visited = visited;
    }
    public boolean isVisiting(){
        return visiting;
    }
    public void visiting(boolean visiting){
        this.visiting = visiting;
    }
    public void addEdge(NodeVisited child){
        children.add(child);
    }
}