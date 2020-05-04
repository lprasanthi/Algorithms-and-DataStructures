// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3312/
public class MaximalSquare {
    class Solution {
        int max_side=0;
        public int maxRow(char[][] matrix, int i, int j, int m, int max){
            int count=1;
            for(int k=i;k<m && k<max; k++){
                if(matrix[k][j] == '0')
                    break;
                count++;
            }
            return count;
        }
        public void maxCol(char[][] matrix, int i, int j, int m, int n, int start){
            if(j>=n || matrix[i][j] != '1') {
               return; 
            }
            if(j-start > max_side)
                return;
            max_side++;
            maxCol(matrix,i,j+1,m,n, start);
            if(j-start >= max_side)
                return;
            int b = maxRow(matrix,i+1,j,m,i+max_side);
            if(b<max_side)
                max_side=j-start;
            return;
        }
        public int maximalSquare(char[][] matrix) {
            int max=0;
            int m = matrix.length;
            if(m==0)
                return 0;
            int n = matrix[0].length;
            for(int i=0; i<m; i++){
               for(int j=0; j<n; j++){
                   if(matrix[i][j] == '1'){
                       maxCol(matrix, i, j, m, n,j);
                       max= Math.max(max_side,max);
                       max_side=0;
                   }
               } 
            }
            return max*max;
        }
    }
}