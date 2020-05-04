import java.util.*;
class Point{
    public int x;
    public int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "("+x+", "+y+")";
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Point){
            Point p = (Point) o;
            return ((p.x == this.x) && (p.y == this.y));
        }
        return false;
    }
    @Override
    public int hashCode(){
        return (x*31)^y;
    }
    // Very Important , If you dont do it it will fail.
    // if you add the same point to the list, you are adding ant.position and when the value changes, list changes.
    public Point clone(){
        return new Point(x,y);
    }
}
class Ant{
    public String orientation;
    public Point position;
    public Ant(String orientation, Point position){
        this.position = position;
        this.orientation = orientation;
    }
    public void move(boolean clockwise){
        String nextOrientation = rotate(clockwise);
        nextPosition(nextOrientation);
        this.orientation = nextOrientation;
    }
    public String rotate(boolean clockwise){
        switch(this.orientation){
            case "right":
                return clockwise ? "bottom" : "top";
            case "left":
                return clockwise ? "top" : "bottom";
            case "top":
                return clockwise ? "right" : "left";
            case "bottom":
                return clockwise ? "left" : "right";
            default :
                return null;
        }
    }
    public void nextPosition(String orientation){
        switch(orientation){
            case "right":
                position.y = position.y+1;
                return;
            case "left":
                position.y = position.y-1;
                return;
            case "top":
                position.x = position.x-1;
                return;
            case "bottom":
                position.x = position.x+1;
                return;
            default :
                return;
        }
    }
}
class Board{
    // Make sure equals and hashcode are overridden if using set. Check the hash function.
    Set<Point> blacks = new HashSet<Point>();
    Ant ant;
    Point min;
    Point max;
    public Board(String orientation, Point start){
        // Important to CLONE else min value, max value are affected
       min = start.clone();
       max = start.clone();
       ant = new Ant(orientation, start);
    }
    public void print() {
        for(int i=min.x; i<=max.x; i++){
            for(int j=min.y; j<=max.y; j++){
                Point p = new Point(i,j);
                if(blacks.contains(p)){
                    System.out.print("black");
                }else{
                    System.out.print("white");
                }
                System.out.print("    ");
            }
            System.out.println();
        }
    }
    public void flip(Point position){
        Point position_clone = position.clone();
        // Very IMPORTANT step. If you dont clone then when ant moves, list changes
        if(blacks.contains(position_clone)){
            blacks.remove(position_clone);
        }else{
            blacks.add(position_clone);
        }
    }
    public void updateMinMax(Point p){
        // System.out.println(p+" "+min+" "+max);
        min.x = Math.min(min.x, p.x);
        min.y = Math.min(min.y, p.y);
        max.x = Math.max(max.x, p.x);
        max.y = Math.max(max.y, p.y);
        // System.out.println(min.x+","+min.y+" and "+max.x+","+max.y);
    }
    public void move(int k){
        for(int i=0; i<k; i++){
            boolean clockwise = !blacks.contains(ant.position);
            flip(ant.position);
            // System.out.println(ant.position+","+ant.orientation+","+clockwise+","+blacks);
            ant.move(clockwise);
            updateMinMax(ant.position);
        }
    }
}
public class LangtonAnt{
    public static void printAntPath(int k){
        Board board = new Board("right", new Point(0,0));
        board.move(k);
        board.print();
    }
    public static void main(String[] args) {
        int k =8;
        printAntPath(k);
    }
}