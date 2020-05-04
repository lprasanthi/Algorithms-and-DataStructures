// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3291/
public class BackspaceStringCompare {
    class Solution {
        private int getNext(String S, int i){
            if(i<0 || S.charAt(i) != '#' )
                return i;
            int count = 1;
            while(count >= 0){
                if(i==0)
                   return -1; 
                if(S.charAt(--i) == '#')
                    count++;
                else
                    count--;
            }
            return i;
        }
        public boolean backspaceCompare(String S, String T) {
            int i=S.length()-1;
            int j=T.length()-1;
            while(i>=0 || j>=0){
                int next_i = getNext(S,i);
                int next_j = getNext(T,j);
                if(next_i<0 && next_j<0)
                    return true;
                if(next_i<0 || next_j<0)
                    return false;
                if(S.charAt(next_i) != T.charAt(next_j))
                    return false;
                i=next_i-1;
                j=next_j-1;
            }
            return true;
        }
    }
}