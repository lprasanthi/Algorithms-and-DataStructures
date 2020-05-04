import java.util.List;
import java.util.ArrayList;
public class ParenGenerator{
    private static void generate(String s,int left,int right,List<String> list){
        if(left > right) {
            return;
        }
        if(left == 0){
            while(right > 0){
                s=s+")";
                right--;
            }
            list.add(s);
            return;
        }
        generate(s+"(",left-1,right,list);
        generate(s+")",left,right-1,list);
    }
    public static List<String> generate(int n){
        List<String> list = new ArrayList<String>();
        generate("(",n-1,n,list);
        return list;
    }
    public static void main(String[] args) {
        List<String> list = generate(3);
        System.out.println(list);
    }
}