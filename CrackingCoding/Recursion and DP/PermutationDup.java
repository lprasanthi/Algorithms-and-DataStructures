import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class PermutationDup{
    public static String insert(String prefix,String s, int pos){
        if(pos == 0)
            return prefix+s;
        return s.substring(0,pos)+prefix+s.substring(pos);
    }
    public static Set<String> permutateHelper(String s){
        Set<String> strings;
        if(s.length() == 1){
            strings = new HashSet<String>();
            strings.add(s);
            return strings;
        }
        String prefix = s.substring(0,1);
        strings = permutateHelper(s.substring(1));
        Set<String> newSet= new HashSet<String>();
        for(String currentString : strings){
            for(int j=0; j<=currentString.length();j++){
                String newString = insert(prefix,currentString,j);
                if(!newSet.contains(newString))
                    newSet.add(newString);
            }
        }
        strings.clear();
        return newSet;
    }
    public static List<String> permutate(String s){
        Set<String> set  = permutateHelper(s);
        List<String> result = new ArrayList<String>(set);
        return result;

    }
    public static void main(String[] args) {
        List<String> list = permutate("abc");
        System.out.println(list); 
    }
}