// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3301/
public class ValidParenthesis2 {
    class Solution {
        private void push(Stack<Integer> stack, int num){
            if(stack.isEmpty() || stack.peek() == -1)
                stack.push(num);
            else{
                int next = stack.pop();
                stack.push(next+num);
            }  
        }
        public boolean checkValidString(String s) {
            Stack<Integer> stack = new Stack<Integer>();
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '('){
                    stack.push(-1);
                }else if(s.charAt(i) == ')'){
                    if(stack.isEmpty())
                        return false;
                    int top = stack.pop();
                    if(top != -1 && !stack.isEmpty()){
                        stack.pop();
                        push(stack, top); 
                    }
                }else{
                    push(stack, 1);
                }
            }
            int count = 0;
            while(!stack.isEmpty()){
                count = count + stack.pop();
                if(count < 0)
                    return false;
            }
            return true;
        }
    }
}