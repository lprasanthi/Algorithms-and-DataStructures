import java.util.List;
import java.util.ArrayList;
/*
    PowerSet: 
    p(0) = {};
    p(1) = {a1},{};
    p(2) = {},{a1},{a2},{a1,a2};
    p(3) = {},{a1},{a2},{a3},{a1,a3},{a2,a3},{a1,a2,a3};
    p(n) = p(n-1)+ p(n-1).each(add(p(n)))
OR
    Generate (2 power n)-1
    Ex: p(3) = (2 power 3) -1 = 7 = 111(binary)
    0- 000 = {}
    1- 001 = {a1}
    2- 010 = {a2}
    3- 011 = {a1,a2}
    4- 100 = {a3}
    5- 101 = {a3,a1}
    6- 110 = {a3,a2}
    7- 111 = {a3,a3,a1}
*/
public class PowerSet{
    public static List<Integer> binarySet(int num){
        List<Integer> set = new ArrayList<Integer>();
        for(int i=0; num > 0 ; i++){
            if(num%2 == 1)
                set.add(i+1);
            num = num/2;
        }
        return set;
    }
    public static List<List<Integer>> getSubsets(int n){
        int result = (int)Math.pow(2,n);
        List<List<Integer>> sets= new ArrayList<List<Integer>>();
        for(int i=0; i<result;i++){
            sets.add(binarySet(i));
        }
        return sets;
    }
    public static List<List<Integer>> subSets(int n){
        List<List<Integer>> sets = new ArrayList<List<Integer>>();
        if(n == 0) {
            List<Integer> set = new ArrayList<Integer>();
            sets.add(set);
            return sets;
        }
        List<List<Integer>> prev = subSets(n-1);
        sets.addAll(prev);
        for(int i=0; i<prev.size();i++) {
            List<Integer> copy = new ArrayList<Integer>(prev.get(i));
            copy.add(n);
            sets.add(copy);
        }
        return sets;
    }
    public static void main(String[] args) {
        List<List<Integer>> sets = getSubsets(3);
        List<List<Integer>> setsRecursion = subSets(3);
        System.out.println(sets); 
        System.out.println(setsRecursion); 
    }
}