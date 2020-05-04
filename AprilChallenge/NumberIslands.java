// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3302/
public class NumberIslands {
    class Solution {
        private void visit(char[][] grid, int row, int col){
            if(row<0 || row>=grid.length || col<0 || col>=grid[0].length)
                return;
            if(grid[row][col] != '1')
                return;
            grid[row][col] = 'V';
            visit(grid,row+1,col);
            visit(grid, row, col+1);
            visit(grid,row-1,col);
            visit(grid, row, col-1);
        }
        public int numIslands(char[][] grid) {
            if(grid.length == 0)
                return 0;
            int count=0;
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    if(grid[i][j] == '1'){
                        count++;
                        visit(grid,i,j);
                    }
                }
            }
            return count;
        }
    } 
}