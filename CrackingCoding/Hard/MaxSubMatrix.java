import java.util.*;
public class MaxSubMatrix{
    public static int[] getRowSum(int[][] matrix, int rowStart, int rowEnd){
        int[] sums = new int[matrix[0].length];
        for(int j=0; j<matrix[0].length;j++){
            int sum=0;
            for(int i=rowStart; i<=rowEnd; i++){
                sum = sum+matrix[i][j];
            } 
            sums[j]= sum;
        }
        return sums;
    }
    public static int[] findMaxSum(int[] sums){
        int maxArray[] = new int[3];
        Arrays.fill(maxArray, 0);
        int runningSum = 0;
        for(int i=0; i<sums.length; i++){
            runningSum = runningSum+sums[i];
            if(runningSum < 0){
                runningSum = 0;
                maxArray[1] = i+1;
            }else if(runningSum > maxArray[0]){
                maxArray[0] = runningSum;
                maxArray[2] = i;
            }
        }
        return maxArray;
    }
    public static int[] maxCols(int[][] matrix, int rowStart, int rowEnd){
        int sum = 0;
        int[] sums = getRowSum(matrix, rowStart, rowEnd);
        int[] maxSum = findMaxSum(sums);
        return maxSum;
    }
    public static int[][] findMaxMatrix(int[][] matrix){
        int maxRowsCols[] = new int[5];
        Arrays.fill(maxRowsCols,0);
        for(int i=0; i<matrix.length; i++){
            for(int j = i; j<matrix.length; j++){
                int[] maxSum = maxCols(matrix, i, j);
                if(maxSum[0] > maxRowsCols[0]){
                    maxRowsCols[0] = maxSum[0];
                    maxRowsCols[1] = i;
                    maxRowsCols[2] = j;
                    maxRowsCols[3] = maxSum[1];
                    maxRowsCols[4] = maxSum[2];
                }
            }
        }
        int rowLength = maxRowsCols[2] - maxRowsCols[1] + 1;
        int[][] subMatrix = new int[rowLength][];
        for(int i=maxRowsCols[1], j=0; i<=maxRowsCols[2]; i++, j++){
            subMatrix[j] = Arrays.copyOfRange(matrix[i], maxRowsCols[3], maxRowsCols[4]+1);
        }
        return subMatrix;
    }
    public static void main(String[] args) {
        int a[][] = {{9, -8, 1, 3, -2},{-3, 7, 6, -2, 4}, {6, -4, -4, 8, -7}};
        int[][] matrix = findMaxMatrix(a);
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}