// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3297/
public class LastStoneWeight {
    class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> q = new PriorityQueue<Integer>((a,b) -> b.intValue()-a.intValue());
            for(int i=0; i<stones.length; i++)
                q.add(stones[i]);
            while(!q.isEmpty()){
                int a = q.poll();
                if(q.isEmpty())
                    return a;
                int b = q.poll();
                if(a == b)
                    continue;
                q.add(a-b);
            }
            return 0;
        }
    }
}