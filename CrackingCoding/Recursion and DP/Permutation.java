import java.util.List;
import java.util.ArrayList;
public class Permutation{
    public static String insert(String prefix,String s, int pos){
        if(pos == 0)
            return prefix+s;
        return s.substring(0,pos)+prefix+s.substring(pos);
    }
    public static List<String> permutate(String s){
        List<String> strings;
        
        if(s.length() == 1){
            strings = new ArrayList<String>();
            strings.add(s);
            return strings;
        }
        String prefix = s.substring(0,1);
        strings = permutate(s.substring(1));
        int size= strings.size();
        for(int i=0; i<size; i++){
            String currentString = strings.remove(0);
            for(int j=0; j<=currentString.length();j++){
                String newString = insert(prefix,currentString,j);
                strings.add(newString);
            }
        }
        return strings;
    }
    private static char[] swap(char[] s, int i, int j){
        char temp = s[i];
        s[i]=s[j];
        s[j]=temp;
        return s;
    }
    public static void swapPerm(char[] s,int start, int end, List<String> list) {
        System.out.println(new String(s)+" "+start+" "+end);
        if(start == end){
            list.add(new String(s));
            return;
        }
        for(int i=start; i<=end;i++){
            System.out.println(i);
            s=swap(s,start,i);
            swapPerm(s,start+1,end,list);
            s=swap(s,start,i);
        }
    }
    public static List<String> swapPerm(String s) {
        char[] arr= s.toCharArray();
        List<String> list = new ArrayList<String>();
        swapPerm(arr,0,arr.length-1,list);
        return list;
    }
    public static void main(String[] args) {
        List<String> list = permutate("abc");
        System.out.println(list);
        List<String> list1 = swapPerm("abc");
        System.out.println(list1);
    }
}