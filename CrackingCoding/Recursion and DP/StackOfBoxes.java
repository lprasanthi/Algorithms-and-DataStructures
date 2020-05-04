/*
    Boxes can be stacked only if the box is strictly smaller in terms of length,width and height
    i.e. b1.length < b2.length && b1.width < b2.width && b1.height < b2.height
    Boxes can't be rotated.
    Find the max height
    Solution : This problem is longest Subsequence variation 
    https://www.youtube.com/watch?v=9mod_xRB-O0&t=373s
*/
import java.util.*;
class Box implements Comparable<Box>{
    public int length;
    public int width;
    public int height;
    Box(int length, int width, int height){
        this.length=length;
        this.width=width;
        this.height=height;
    }
    public boolean isSmallerThan(Box b) {
        return this.length < b.length && this.width < b.width && this.height < b.height;
    }
    @Override
    public int compareTo(Box a) { 
        return this.height - a.height;
    }
    @Override
    public String toString(){
        return "("+this.length+", "+this.width+", "+this.height+")";
    }
      
}
public class StackOfBoxes{
    private static int longestSubSequence(List<Box> boxes, int[] buffer){
        int max = 1;
        for(int i=0; i<boxes.size(); i++){
            for(int j=0; j<i;j++){
                if(boxes.get(j).isSmallerThan(boxes.get(i))){
                    buffer[i] = Math.max(buffer[i],buffer[j]+boxes.get(i).height);
                }
            }
            max= Math.max(max,buffer[i]);
        }
        return max;
    }
    public static int stackHeight(List<Box> boxes){
        Collections.sort(boxes);
        int[] buffer = new int[boxes.size()];
        for(int i=0; i<buffer.length;i++)
            buffer[i]=boxes.get(i).height;
        System.out.println(boxes);
        return longestSubSequence(boxes,buffer);
    }
    public static void main(String[] args) {
        List<Box> boxes = new ArrayList<Box>();
        boxes.add(new Box(1,2,3));
        boxes.add(new Box(1,4,6));
        boxes.add(new Box(2,8,16));
        boxes.add(new Box(1,1,2));
        boxes.add(new Box(3,5,9));
        int maxHeight = stackHeight(boxes);
        System.out.println(maxHeight);
    }
}