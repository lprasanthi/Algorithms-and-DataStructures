import java.util.*;
class StackWithMin extends Stack<Integer>{
    Stack<Integer> minStack;
    public StackWithMin(){
        super();
        minStack = new Stack<Integer>();
    }
    public void push1(int val){
        if(val < min()){
            minStack.push(val);
        }
        super.push(val);
    }
    public int pop1(){
        int val = super.pop();
        if(val == min())
            minStack.pop();
        return val;
    }
    public int min(){
        if(minStack.isEmpty())
            return Integer.MAX_VALUE;
        return minStack.peek().intValue();
    }
    public void printHelper(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int val = s.pop().intValue();
        printHelper(s);
        System.out.print(val+" , ");
        s.push(val);
    }
    public void print(){
        printHelper(this);
        System.out.println("Elements in Min stack");
        printHelper(minStack);
    }
    
}
public class StackMin{
    public static void main(String[] args) {
        StackWithMin s = new StackWithMin();
      s.push1(3);
      s.push1(4);
      s.push1(10);
      s.push1(1);
      s.push1(2);
      s.print();
    }
}