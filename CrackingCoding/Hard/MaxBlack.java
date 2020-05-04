class Result{
    int row, col,size;
    public Result(int row, int col, int size){
        this.row = row;
        this.col = col;
        this.size = size;
    }
    public String toString(){
        return "("+row+", "+col+")"+size;
    }
}
class SubSquare{
    public int right;
    public int below;
    public SubSquare(int right, int below){
        this.right = right;
        this.below = below;
    }
    public SubSquare(){
        right = 0;
        below = 0;
    }
    public String toString(){
        return right+","+below+"    ";
    }
}
public class MaxBlack{
    public static SubSquare[][] preprocess(int[][] matrix){
        SubSquare[][] square = new SubSquare[matrix.length][matrix.length];
        for(int i=matrix.length-1; i>=0;i--){
            for(int j=matrix.length-1; j>=0;j--){
                square[i][j] = new SubSquare(0,0);
                if(matrix[i][j] != 0){
                    square[i][j] = new SubSquare(1,1);
                    if(j+1 < matrix.length){
                        square[i][j].right = square[i][j+1].right+square[i][j].right;
                    }
                    if(i+1 < matrix.length){
                        square[i][j].below = square[i+1][j].below+square[i][j].below;
                    }   
                }  
            }
        }
        return square;
    }
    public static boolean isSquare(SubSquare[][] square, int row, int col, int size){
        return (square[row][col].right >= size && square[row][col].below >= size &&
            square[row+size-1][col].right >=size && square[row][col+size-1].below >=size);
    }
    public static Result findNthSquare(SubSquare[][] square, int size){
        int count = square.length-size+1;
        for(int i=0; i<count;i++){
            for(int j=0; j<count;j++){
                if(isSquare(square,i,j,size)){
                    return new Result(i,j,size);
                }
            } 
        }
        return null;
    }
    public static Result findSubSquare(int[][] matrix){
        SubSquare square[][] = preprocess(matrix);
        Result result=null;
        for(int i=square.length; i>0;i--){
            result=findNthSquare(square,i);
            if(result != null){
                return result;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int matrix[][] = {{0,1,0},{1,1,0},{1,1,0}};
        Result result = findSubSquare(matrix);
        // for(int i=0; i<result.length;i++){
        //     for(int j=0; j<result.length;j++){
        //         System.out.print(result[i][j]);
        //     }
        //     System.out.println();
        // }
        System.out.println(result);
    }
}