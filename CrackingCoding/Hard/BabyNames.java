import java.util.*;
class Node{
    public String name;
    public int frequency;
    public List<Node> children;
    public boolean visited;
    public Node(String name, int frequency){
        this.name = name;
        this.frequency = frequency;
        this.visited = false;
        this.children = new ArrayList<Node>();
    }
    public void addEdge(Node child){
        children.add(child);
    }
    public String toString(){
        return "name: "+name+" frequency: "+frequency;
    }
}
class Graph{
    public Map<String, Node> vertices;
    public Graph(){
        vertices = new HashMap<String, Node>();
    }
    public Collection<Node> getNodes(){
        return vertices.values();
    }
    public void createNode(String name, int frequency){
        Node node = new Node(name, frequency);
        vertices.put(name,node);
    }
    public void addEdge(String from, String to){
        Node source = vertices.get(from);
        Node destination = vertices.get(to);
        if(source != null)
            source.addEdge(destination);
        if(destination != null)
            destination.addEdge(source);
    }
    public Node getNode(String name){
        return vertices.get(name);
    }
}
public class BabyNames{
    private static void createNodes(Map<String, Integer> names, Graph graph){
        for(Map.Entry<String, Integer> entry: names.entrySet()){
            graph.createNode(entry.getKey(), entry.getValue());
        }
    }
    private static void createEdges(String[][] synonyms, Graph graph){
        for(String[] each : synonyms){
            graph.addEdge(each[0], each[1]);
        }
    }
    private static Graph constructGraph(Map<String, Integer> names, String[][] synonyms){
        Graph graph = new Graph();
        createNodes(names, graph);
        createEdges(synonyms, graph);
        return graph;
    }
    private static int DFS(Node node){
        int frequency = node.frequency;
        node.visited = true;
        List<Node> children = node.children;
        if(children == null || children.size() == 0){
            return frequency;
        }
        for(Node child : children){
            if(!child.visited){
                frequency+=DFS(child);
            }
        }
        return frequency;     
    }
    public static Map<String, Integer> DFS(Graph graph){
        Collection<Node> vertices = graph.getNodes();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(Node vertex : vertices){
            if(!vertex.visited){
                String key = vertex.name;
                int value = DFS(vertex);
                map.put(key, value);
            }
        }
        return map;
    }
    public static Map<String, Integer> getTrueFrequencies(Map<String, Integer> names, String[][] synonyms){
        Graph graph = constructGraph(names, synonyms);
        return DFS(graph);   
    }
    public static void main(String[] args) {
        Map<String, Integer> names = new HashMap<String, Integer>();
        String[][] synonyms = {{"Jonathan", "John"},{"Jon", "Johnny"},{"Johnny", "John"},{"Kari", "Carrie"},{"Carleton", "Carlton"}};
        int frequency[] = {10,3,2,3,11,8,2,9,5};
        String nameList[] = {"John","Jon","Davis","Kari","Johnny","Carlton","Carleton","Jonathan","Carrie"};
        for(int i=0; i<frequency.length; i++){
            names.put(nameList[i], frequency[i]);
        }
        Map<String, Integer> realNames = getTrueFrequencies(names, synonyms);
        System.out.println(realNames);

    }
}