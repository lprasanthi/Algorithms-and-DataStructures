// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3303/
public class MinPathSum {
    class Solution {
        private int hash(int i, int j, int n){
            return i*n+j;
        }
        private int minPathSum(int[][] grid, int i, int j, Map<Integer, Integer> map, int m, int n){
            if(i > m-1 || j > n-1)
                return Integer.MAX_VALUE;
            int key = hash(i,j,n);
            if(map.containsKey(key)){
                return map.get(key);
            }
            int left = minPathSum(grid,i+1,j,map,m,n);
            int right = minPathSum(grid,i,j+1,map,m,n);
            int min = Math.min(left, right)+grid[i][j];
            map.put(key, min);
            return min;
        }
        private int minIte(int[][] grid){
            int m = grid.length;
            if(m == 0)
                return 0;
            int n = grid[0].length;
            PriorityQueue<int[]> q = new PriorityQueue<int[]>((x, y) -> x[1] - y[1]);
            q.add(new int[]{m*n-1, grid[m-1][n-1]});
            Set<Integer> visited = new HashSet<Integer>();
            visited.add(m*n-1);
            while(!q.isEmpty()){
                PriorityQueue<int[]> s = new PriorityQueue<int[]>((x, y) -> x[1] - y[1]);
                while(!q.isEmpty()){
                    int[] pos=q.poll();
                    if(pos[0] == 0)
                        return pos[1];
                    int i=pos[0]/n;
                    int j=pos[0]%n;
                    int top = pos[0]-n;
                    int left = pos[0]-1;
                    if(top>=0 && top<m*n-1 && !visited.contains(top)){
                        int sum = grid[i-1][j]+pos[1];
                        s.add(new int[]{top, sum});
                        //System.out.println("entered; "+sum+","+top);
                        visited.add(top);
                    }
                    if(left>=0 && left<m*n-1 && !visited.contains(left)){
                       int sum = grid[i][j-1]+pos[1];
                        visited.add(left);
                        //System.out.println("entered: "+sum+","+left);
                        s.add(new int[]{left, sum});
                    }
                }
                q=s;
            }
            return -1;
        }
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            if(m == 0)
                return 0;
            int n = grid[0].length;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            map.put(hash(m-1,n-1,n), grid[m-1][n-1]);
            return minPathSum(grid,0,0,map,m,n);
            //return minIte(grid);
        }
    }
}