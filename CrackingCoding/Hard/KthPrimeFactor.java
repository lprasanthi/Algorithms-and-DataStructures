import java.util.*;
public class KthPrimeFactor{
    public static int findKthPrimeFactor(int k){
        Queue<Integer> q3 = new LinkedList<Integer>();
        Queue<Integer> q5 = new LinkedList<Integer>();
        Queue<Integer> q7 = new LinkedList<Integer>();
        int val = 1;
        q3.add(1);
        for(int i=0; i<=k;i++){
            int v3= q3.size() > 0 ? q3.peek() : Integer.MAX_VALUE;
            int v5= q5.size() > 0 ? q5.peek() : Integer.MAX_VALUE;
            int v7= q7.size() > 0 ? q7.peek() : Integer.MAX_VALUE;
            val = Math.min(Math.min(v3,v5),v7);
            if(val == v3) {
                q3.remove();
                q3.add(3*val);
                q5.add(5*val);    
            }else if(val == v5){
                q5.remove();
                q5.add(5*val);
            }else{
                q7.remove();
            }
            q7.add(7*val);
        }
        return val;
    }
    public static void main(String[] args) {
        System.out.println(findKthPrimeFactor(10));
    }
}