// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3308/
public class BitwiseANDNumbersRange {
    class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            int result = 0;
            int count = 0;
            int power = 1;
            int a=m, b=n;
            while(m > 0){
               if(m%2 ==1 && n%2 == 1 && b-a < power){
                   result = result + power;
               }
                m=m/2;
                n=n/2;
                count++;
                power = power*2;
            }
            return result;
        }
    } 
}