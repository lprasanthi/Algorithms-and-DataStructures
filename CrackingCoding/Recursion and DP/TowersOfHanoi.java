import java.util.Stack;
class Tower{
    public Stack<Integer> disks ;
    public int size;
    Tower(){
        disks= new Stack<Integer>();
        size=0;
    }
    public void add(int d){
        disks.push(d);
        size++;
    }
    public void addN(int n){
        for(int i=n; i>0; i--){
            disks.push(i);
            size++;
        }     
    }
    public int remove(){ 
        if(size>0){
            size--;
            return disks.pop();
        }
        return -1;
    }
    public int size(){
        return size;
    }
    public String toString(){
        return disks+"";
    }
}
public class TowersOfHanoi{
    public static void move(Tower from, Tower to, Tower buffer,int n){
        if(n<1)
            return;
        if(n==1) {
            int disk = from.remove();
            to.add(disk);
            return;
        }
        move(from,buffer,to,n-1);
        move(from,to,buffer,1);
        move(buffer,to,from,n-1);
    }
    public static void move(Tower t1, Tower t2){
        Tower buffer = new Tower();
        move(t1,t2,buffer,t1.size());
    }
    public static void main(String[] args) {
        Tower from = new Tower();
        Tower to = new Tower();
        from.addN(4);
        System.out.println(from);
        System.out.println(to);
        move(from,to);
        System.out.println(from);
        System.out.println(to);
    }
}