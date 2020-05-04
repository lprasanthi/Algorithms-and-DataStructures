import java.util.*;
class MyQueue{
    Stack<Integer> newStack, oldStack;
    int capacity ;
    public MyQueue(int n){
        capacity=n;
        oldStack= new Stack<Integer>();
        newStack= new Stack<Integer>();
    }
    public boolean add(Integer val){
        if(size() == capacity)
            return false;
        newStack.push(val);
        return true;
    }
    public void shiftStacks(){
        if(!oldStack.isEmpty()){
            return;
        }
        while(!newStack.isEmpty()){
            oldStack.push(newStack.pop());
        }
    }
    public int remove(){
        shiftStacks();
        return oldStack.pop().intValue();  
    }
    public int peek(){
        shiftStacks();
        return oldStack.peek().intValue(); 
    }
    public int size(){
        return newStack.size()+oldStack.size();
    }
    public void print(){
        shiftStacks();
        System.out.println(oldStack);
    }
}
public class QueueWithStacks{
    public static void main(String[] args) {
        MyQueue q= new MyQueue(10);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.remove();
        q.remove();
        q.remove();
        q.print();
    }
}