import Graph.NodeVisited;
import Graph.Node;
import Graph.DirectedGraph;
public class RouteBetweenNodes{
    public static boolean isRouteDfsHelper(NodeVisited start, NodeVisited end)
        boolean found = false;
        if(start == end)
            return true;
        start.visited(true);
        for(NodeVisited child : start.children){
           if(!child.isVisited()) {
               found = isRouteDfsHelper(child,end);
               if(found)
                return found;
           }
        }
        return found;
    }
    public static boolean isRouteDfs(NodeVisited start, NodeVisited end){
        return isRouteDfsHelper(start,end);
    }
    public static void main(String[] args) {
        DirectedGraph<NodeVisited> g = new DirectedGraph<NodeVisited>();
        NodeVisited n1 = new NodeVisited(1);
        NodeVisited n2 = new NodeVisited(2);
        NodeVisited n3 = new NodeVisited(3);
        NodeVisited n4 = new NodeVisited(4);
        NodeVisited n5 = new NodeVisited(5);
        g.addEdge(n1,n2);
        g.addEdge(n1,n3);
        g.addEdge(n2,n3);
        g.addEdge(n2,n5);
        g.addEdge(n3,n1);
        g.addEdge(n4,n2);
        g.addEdge(n4,n5);
        System.out.println(isRouteDfs(n3,n5));
    }
}