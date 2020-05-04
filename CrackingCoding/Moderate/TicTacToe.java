public class TicTacToe{
    private static boolean hasWinnerDiag(String[][] board,boolean left){
        int n= board.length-1;
        String val = board[0][0];
        for(int i=0; i<=n;i++){
            int j = left ? i : n-i;
            if(val != board[i][j])
                return false;
        }
        return true; 
    }
    private static boolean hasWinnerRow(String[][] board,int row){
        int n= board.length-1;
        String val = board[row][0];
        for(int i=0;i<=n;i++){
            if(board[row][i] != val)
                return false;
        } 
        return true;
    } 
    private static boolean hasWinnerCol(String[][] board,int col){
        int n= board.length-1;
        String val = board[0][col];
        for(int i=0;i<=n;i++){
            if(board[i][col] != val)
                return false;
        } 
        return true; 
    }  
    public static String whoWon(String[][] board){
        for(int i=0; i<board.length; i++){
            if(i == 0){
                if(hasWinnerDiag(board,true)){
                    return board[i][i];
                }
            }else if(i == board.length -1){
                if(hasWinnerDiag(board,false)){
                    return board[i][i];
                } 
            }
            if(hasWinnerRow(board,i))
                return board[i][0];
            if(hasWinnerCol(board,i))
                return board[0][i];
        }
        return "NO_WINNER";
    }
    public static void main(String[] args) {
        String board[][] = {{"O","X","O"},{"O","O","X"},{"X","X"," "}};
        String s = whoWon(board);
        System.out.println(s);
    }
}