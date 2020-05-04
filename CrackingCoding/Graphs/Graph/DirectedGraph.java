package Graph;
import java.util.*;
import Graph.*;
public class DirectedGraph<T>{
    List<T> vertices;
    private int index = -1;
    public DirectedGraph() {
        vertices = new ArrayList<T>();
    }
    public void addVertex(T node){
        vertices.add(node);
    }
    public void addEdge(Node start, Node end){
        start.addEdge(end);
    }
    public void addEdge(NodeVisited start, NodeVisited end){
        start.addEdge(end);
    }
    public T get(int data){
        for(T vertex : vertices){
            if(vertex instanceof NodeVisited){
                NodeVisited cur = (NodeVisited)vertex;
                if(cur.data == data){
                    return vertex;
                }
            }else{
                //throw exception
            }
        }
        return null;
    }
    public T get(char cdata){
        for(T vertex : vertices){
            if(vertex instanceof NodeVisited){
                NodeVisited cur = (NodeVisited)vertex;
                if(cur.cdata == cdata){
                    return vertex;
                }
            }else{
                //throw exception
            }
        }
        return null;
    }
    public int size(){
        return vertices.size();
    }
    public T head(){
        index++;
        return vertices.get(index);
    }
    public T next(){
        index++;
        if(index<vertices.size())
            return vertices.get(index);
        return  null;
    }
}