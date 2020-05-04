import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
class Point{
    int row;
    int col;
    Point(int row, int col){
        this.row=row;
        this.col=col;
    }
    public String toString(){
        return "("+row+","+col+")";
    }
}
public class RobotGrid{
    
    private static boolean getPath(boolean maze[][],int row, int col, Set<Point> set, List<Point> path){
        if(row >= maze.length || col >= maze[0].length){
            return false;
        }
        if(row == (maze.length-1) && col==(maze[0].length-1)){
            path.add(new Point(row,col));
            return true;
        }
        Point point = new Point(row,col);
        if(!maze[row][col] || set.contains(point)){
            return false;
        }
        boolean isExist = getPath(maze,row+1,col,set,path) || getPath(maze, row,col+1,set,path);
        if(!isExist){
            set.add(point);
        }else {
            path.add(point);
        }
        return isExist;
    }
    public static List<Point> getPath(boolean maze[][]){
       Set<Point> points = new HashSet<Point>();
       List<Point> path = new ArrayList<Point>();
       getPath(maze,0,0,points,path);
       return path;
    }
    public static void main(String[] args) {
       boolean maze[][]={
        {true,true,true,true,true},
        {false,true,true,true,false},
        {false,false,false,true,true},
        {false,false,false,true,true},
        {false,false,false,false,true}
       };
       List<Point> path = getPath(maze);
       for(int i=0; i<path.size();i++){
           System.out.println(path.get(i));
       }
    }
}