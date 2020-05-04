// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3311/
public class LongestCommonSubsequence {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] map=new int[text1.length()+1][text2.length()+1];
            int max=0;
            for(int i=1; i<=text1.length(); i++){
                for(int j=1; j<=text2.length(); j++){
                    if(text1.charAt(i-1)==text2.charAt(j-1))
                        map[i][j]+= map[i-1][j-1]+1;
                    else
                        map[i][j]= Math.max(map[i][j-1], map[i-1][j]);
                    max=Math.max(map[i][j],max);
                }
            }
            return max;
        }
    }
}