import java.util.*;
public class SortStack{
    public static void sort(Stack<Integer> s){
        Stack<Integer> temp = new Stack<Integer>();
        int min;
        while(!s.isEmpty()){
            min= s.pop();
            while(!temp.isEmpty() && temp.peek() < min){
                s.push(temp.pop());
            }
            temp.push(min);
        }
        while(!temp.isEmpty()){
            s.push(temp.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(8);
        s.push(1);
        s.push(18);
        s.push(12);
        s.push(10);
        s.push(9);
        System.out.println(s);
        sort(s);
        System.out.println(s);
    }
}