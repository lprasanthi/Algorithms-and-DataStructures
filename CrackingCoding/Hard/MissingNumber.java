import java.util.*;
class BitInteger{
    int num;
    public static int INTEGER_SIZE = 32;
    public BitInteger(int num){
        this.num = num;
    }
    public int fetch(int i){
        int a = 1 << i;
        if((a & num) == 0){
            return 0;
        }
        return 1;
    }
    public String toString(){
        return num+"";
    }
}
public class MissingNumber{
    private static int find(List<BitInteger> list, int index){
        if(index == BitInteger.INTEGER_SIZE)
            return 0;
        List<BitInteger> zeroList = new ArrayList<BitInteger>(); 
        List<BitInteger> oneList = new ArrayList<BitInteger>(); 
        for(int i=0; i<list.size(); i++){
            BitInteger element= list.get(i);
            if(element.fetch(index) == 0){
                zeroList.add(element);
            }else{
                oneList.add(element);
            }
        }
        if(zeroList.size() > oneList.size()){
            //  1 is removed, eliminate zero list
            int bit = find(oneList, index+1);
            return (bit << 1) | 1;
        }else{
           //  0 is removed, eliminate one list
           int bit = find(zeroList, index+1);
           return (bit << 1) | 0; 
        }
    }
    public static int find(List<BitInteger> list){
        return find(list, 0);
    }
    public static void main(String[] args) {
        List<BitInteger> list = new ArrayList<BitInteger>(); 
        int n = 99;
        for(int i=0; i<100; i++){
            if(i != n)
                list.add(new BitInteger(i));
        }
        System.out.println(list);
        System.out.println(find(list));
    }
}