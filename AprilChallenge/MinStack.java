// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3292/

public class MinStack {
    Stack<Integer> s;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        s= new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x<=min){
            s.push(min);
            min = x;
        }
        s.push(x);
    }
    
    public void pop() {
        if(s.pop() == min) min = s.pop(); 
    }
    
    public int top() {
        
        return s.peek(); 
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
