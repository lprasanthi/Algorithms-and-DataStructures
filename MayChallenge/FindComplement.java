// https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3319/

class Solution {
    public int findComplement(int num) {
        int sum = 0;
        int count=1;
        while(num != 0){
            int cur=num%2;
            num=num/2;
            sum= sum+count*(cur==1 ? 0 : 1);
            count=count*2;
        }
        return sum;
    }
    public int findComplement_2(int num) {
        // n is a length of num in binary representation
        int n = (int)( Math.log(num) / Math.log(2) ) + 1;
        int b = (1<<n)-1;
        return num^b;
    }
}