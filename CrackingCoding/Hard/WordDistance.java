import java.util.*;
class WordSet{
    public int first;
    public int second;
    public WordSet(int first, int second){
        this.first = first;
        this.second = second;
    }
    private int diff(WordSet w){
        return Math.abs(w.first-w.second);
    }
    public void updateMin(WordSet w){
       if(diff(w) == 0 || diff(this) < diff(w)){
           w.first = this.first;
           w.second = this.second;
       }
       return;
    }
    public String toString(){
        return first+", "+second;
    }
}
public class WordDistance{
    
    public static WordSet distance(String[] file, String first, String second){
        WordSet set = new WordSet(Integer.MIN_VALUE, Integer.MAX_VALUE);
        WordSet min = new WordSet(0, 0);
        for(int i=0; i<file.length;i++){
            if(file[i] == first){
                 set.first = i;
                 set.updateMin(min);
            }else if(file[i] == second){
                set.second = i;
                set.updateMin(min);
            }
        }
        return min;
    }
    public static void main(String[] args) {
        String file[]={"Adi","Test","Prash","Temp","Adi","Adi","Prash","Hello","World"};
        WordSet set = distance(file,"Adi","Prash");
        System.out.println(set);
    }
}