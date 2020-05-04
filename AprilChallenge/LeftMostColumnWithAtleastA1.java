// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/
public class LeftMostColumnWithAtleastA1 {
    /**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    private int search(BinaryMatrix binaryMatrix, int row, int col, int m, int n){
        int min=n;
        while(row<m && col>=0) {
            while(row<m && binaryMatrix.get(row,col) == 0){
                row++;
            }
            if(row == m)
                return min == n ? -1 : min;
            while(col>=0 && binaryMatrix.get(row,col) == 1){
                col--;
            }
            col++;
            row++;
            min=col;
        }
        return min == n ? -1 : min;
    }
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int m = binaryMatrix.dimensions().get(0);
        int n = binaryMatrix.dimensions().get(1);
        return search(binaryMatrix,0,n-1,m,n);
        
    }
}
}