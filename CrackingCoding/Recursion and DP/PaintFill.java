public class PaintFill{
    public enum Color{
        RED,BLUE,GREEN,YELLOW;
    };
    private static void paint(Color[][] screen,int row, int col, Color ocolor, Color ncolor){
        if(row < 0 || row >= screen.length || col < 0 || col >= screen[0].length)
            return;
        if(screen[row][col] != ocolor)
            return;
        screen[row][col] = ncolor;
        paint(screen,row,col+1,ocolor,ncolor);
        paint(screen,row+1,col,ocolor,ncolor);
        paint(screen,row,col-1,ocolor,ncolor);
        paint(screen,row-1,col,ocolor,ncolor);
    }
    public static void paint(Color[][] screen,int row, int col, Color ncolor){
        paint(screen,row,col,screen[row][col],ncolor); 
    }
    public static void main(String[] args) {
        Color[][] screen={{Color.RED,Color.BLUE,Color.RED,Color.BLUE},
        {Color.GREEN,Color.RED,Color.RED,Color.RED},
        {Color.BLUE,Color.GREEN,Color.RED,Color.GREEN},
        {Color.BLUE,Color.RED,Color.RED,Color.GREEN}};
        System.out.println("BEFORE PAINTING================");
        for(int i=0;i<screen.length;i++){
            for(int j=0;j<screen[0].length;j++){
                System.out.print(screen[i][j]+",");
            }
            System.out.println();
        }
        System.out.println("AFTER PAINTING==================");
        paint(screen, 1, 1, Color.YELLOW);
        for(int i=0;i<screen.length;i++){
            for(int j=0;j<screen[0].length;j++){
                System.out.print(screen[i][j]+",");
            }
            System.out.println();
        }
    }
}