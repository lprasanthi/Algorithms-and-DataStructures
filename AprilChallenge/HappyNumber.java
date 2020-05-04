//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3284/
public class HappyNumber {
    private int happy(int n){
        int sum=0;
        while(n>0){
            int num=n%10;
            sum=sum+(num)*(num);
            n=n/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while(true){
            slow= happy(slow);
            fast= happy(happy(fast));
            if(slow == 1){
                return true;
            }
            if(slow == fast){
                return false;
            }
        }
    }
}