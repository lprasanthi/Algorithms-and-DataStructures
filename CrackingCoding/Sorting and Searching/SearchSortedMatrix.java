class Point{
    public int row,col;
    public Point(int row,int col){
        this.row=row;
        this.col=col;
    }
    public String toString(){
        return row+", "+col;
    }
}
public class SearchSortedMatrix{
    private static Point searchMatrix(int[][] a, int lowi, int lowj, int highi, int highj, int n){
        if(lowi <0 || highi <0 || lowj < 0 || lowj < 0)
            return null;
        if(lowi >= a.length || highi >= a.length)
            return null;
        if(lowj >= a[0].length || highj >= a[0].length)
            return null;
        if(lowi > highi || lowj > highj)
            return null;
        int i = (lowi+highi)/2;
        int j = (lowj+highj)/2;
        if(n == a[i][j]){
            return new Point(i,j);
        }else if(n > a[i][j]){
            Point p = searchMatrix(a,lowi,j+1,i,highj,n);
            if(p == null){
                p = searchMatrix(a,i+1,lowj,highi,j,n);
                if(p == null){
                    return searchMatrix(a,i+1,j+1,highi,highj,n);
                }
                return p;
            }
            return p;   
        }
        Point p =  searchMatrix(a,lowi,lowj,i-1,j-1,n);
        if(p == null){
            p = searchMatrix(a,lowi,j,i-1,highj,n);
            if(p == null)
                return searchMatrix(a,i,lowj,highi,j-1,n);
            return p;
        }
        return p;
    }
    public static Point searchMatrix(int[][] a, int n){
        return searchMatrix(a,0,0,a.length-1,a[0].length-1,n);
    }
    public static void main(String[] args) {
        int a[][]={{15,20,40,85,88},
        {20,35,80,93,98},
        {30,55,95,105,110},
        {40,80,100,120,125}};
        Point p= searchMatrix(a, 130);
        System.out.println(p);
    }
}