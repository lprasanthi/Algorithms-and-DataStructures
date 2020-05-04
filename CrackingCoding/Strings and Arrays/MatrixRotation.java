public class MatrixRotation{
    public static void rotate(int[][] a){
        int n= a.length-1;
        for(int i=0; i<a.length/2;i++){
            for(int j=i; j< n-i; j++){
                int temp = a[i][j];
                a[i][j]=a[n-j][i];
                a[n-j][i]=a[n-i][n-j];
                a[n-i][n-j]=a[j][n-i];
                a[j][n-i]=temp;
            }
        }
    }
    public static void main(String[] args) {
        int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(a);

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(a[i][j]+"   ");
            }
            System.out.println();
        }
    }
}