import java.util.*;
class Listy{
    ArrayList<Integer> list;
    public Listy(){
        list=new ArrayList<Integer>();
    }
    public void add(int element){
        list.add(element);
    }
    public void addAll(int[] list){
        for(int i=0;i<list.length;i++){
            this.list.add(list[i]);
        }
    }
    public int elementAt(int index){
        if(index >= list.size()){
            return -1;
        }else{
            return list.get(index);
        }
    }
    public void print(){
        for(int i=0;i<list.size();i++)
            System.out.println("index-->"+i+",element-->"+list.get(i));
    }
}
public class SortedSearchNoSize{
    public static int search(Listy list, int low, int high, int n){
        if(low > high)
            return -1;
        int mid = (low+high)/2;
        int element = list.elementAt(mid);
        if(element == n)
            return mid;
        if(n < element || element == -1)
            return search(list,low,mid-1,n);
        return search(list,mid+1,high,n);
    }
    public static int search(Listy list, int n){
        int element= list.elementAt(0);
        if(n == element)
            return 0;
        int i=1;
        while(element != -1 &&  element <= n){
            if(n == element)
                return i;
            i = i*2;
            element = list.elementAt(i);
        }
        return search(list,(i/2)+1,i,n);
    }
    public static void main(String[] args) {
        Listy list = new Listy();
        int size=10;
        int arr[]=new int[size]; 
        for(int i=0;i<size;i++){
            arr[i]=i+2;
        }
        list.addAll(arr);
        list.print();
        int n=10;
        int index=search(list, n);
        System.out.println("found at: "+index);
    }
}