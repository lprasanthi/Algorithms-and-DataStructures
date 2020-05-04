import java.util.*;
public class Calculator{
    private static int precedence(char cur){
        switch(cur){
            case '*': return 2;
            case '/': return 2;
            case '+': return 1;
            case '-': return 1;
            default : return 0;
        }
    }
    private static boolean isOperator(char c){
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }
    private static double calculate(double a, double b, char operator){
        switch(operator){
            case '*': return a*b;
            case '/': return a/b;
            case '+': return a+b;
            case '-': return a-b;
            default : return 0;
        }
    }
    private static void calculate(Stack<Character> operatorStack, Stack<Double> operandStack){
        double b = operandStack.pop();
        double a = operandStack.pop();
        char operator = operatorStack.pop();
        double result = calculate(a,b,operator);
        operandStack.push(result);
    } 
    public static double evaluate(String expression){
        Stack<Double> operandStack = new Stack<Double>(); 
        Stack<Character> operatorStack = new Stack<Character>(); 
        for(int i=0; i< expression.length(); i++){
            char cur = expression.charAt(i);
            boolean operator = isOperator(cur);
            if(operator){
                while(!operatorStack.isEmpty() && precedence(cur) <= precedence(operatorStack.peek())){
                    calculate(operatorStack, operandStack);
                }
                operatorStack.push(cur);
            }else {
                String s ="";
                while(i<expression.length() && !isOperator(expression.charAt(i))){
                    cur = expression.charAt(i);
                    s=s+cur;
                    i++;
                }
                i--;
                if(s.equals(""))
                    operandStack.push(Double.parseDouble(s+cur));
                else
                    operandStack.push(Double.parseDouble(s));  
            }
        }
        while(!operatorStack.isEmpty()){
            calculate(operatorStack, operandStack);
        }
        return operandStack.pop();
    }
    public static void main(String[] args) {
        String expression = "2*3+5/6*3+15";
        double result = evaluate(expression);
        System.out.println(result);
    }
}