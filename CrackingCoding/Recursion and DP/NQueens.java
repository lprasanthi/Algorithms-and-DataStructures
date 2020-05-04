import java.util.Arrays; 
public class NQueens{
    private static boolean checkCol(int[] board,int row,int col){
        for(int i=0; i<row;i++){
            if(board[i] == col)
                return false;
        }
        return true;
    }
    private static boolean checkDiag(int[] board,int row,int col){
        for(int i=0; i<row;i++){
            int j= board[i];
            if(Math.abs(row-i) == Math.abs(col-j))
                return false;
        }
        return true;
    }
    private static void placeQueens(int n,int[] board,int row,int col){
        if(row > n)
            return;
        for(int i = col+1;i<=n;i++){
            if(checkCol(board,row,i) && checkDiag(board,row,i)){
                board[row] = i;
                placeQueens(n,board,row+1,-1);
                return;
            }
        }
        placeQueens(n,board,row-1,board[row-1]);
    }
    public static int[] placeQueens(int n){
        int[] board = new int[n];
        Arrays.fill(board,-1);
        placeQueens(n-1,board,0,-1);
        return board;
    }
    public static void main(String[] args) {
        int[] board=placeQueens(8);
        for(int i=0;i<board.length;i++)
            System.out.println(board[i]);
    }
}