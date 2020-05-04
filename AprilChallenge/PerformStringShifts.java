// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3299/
public class PerformStringShifts {
    class Solution {
        public String stringShift(String s, int[][] shift) {
            int count = 0;
            String result="";
            for(int[] each : shift){
                int factor = each[0] == 0 ? -1 : 1;
                count += each[1]*factor;
            }
            count = count % s.length();
            int index = count < 0 ? count*-1 : s.length() - count;
            result = result + s.substring(index) + s.substring(0, index);
            return result;
        }
    }
}