import java.util.*;
public class PondSizes{
    private static int findWater(int[][] land,int i, int j){
        if(i <0 || i>= land.length || j <0 || j>= land.length || land[i][j] != 0){
            return 0;
        }
        land[i][j] = -1;
        return 1+findWater(land, i+1,j) + findWater(land, i,j+1) + findWater(land, i+1,j-1) + findWater(land, i+1,j+1);
    }
    public static List<Integer> getPondSizes(int[][] land){
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if(land[i][j] == 0){
                    list.add(findWater(land,i,j));
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int land[][]={{0,2,1,0},{0,1,0,0},{1,1,0,1},{0,1,0,1}};
        List<Integer> ponds = getPondSizes(land);
        System.out.println(ponds);
    }
}