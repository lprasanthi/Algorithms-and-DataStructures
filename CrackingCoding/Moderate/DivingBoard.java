import java.util.*;
public class DivingBoard{
    public static List<Integer> allPossibleLengths(int k, int shorter, int longer){
        List<Integer> lengths = new ArrayList<Integer>();
        for(int i=0; i<=k; i++){
            lengths.add(i*shorter+(k-i)*longer);
        }
        return lengths;
    }
    public static void main(String[] args) {
        int k = 3;
        int shorter = 1;
        int longer = 2;
        List<Integer> lengths = allPossibleLengths(k,shorter,longer);
        System.out.println(lengths);
    }
}