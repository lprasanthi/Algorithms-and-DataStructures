import java.util.Arrays;
class Result{
    int start;
    int end;
    public Result(){
        start = 0;
        end=0;
    }
    public Result(int start, int end){
        this.start = start;
        this.end=end;
    }
    public String toString(){
        return "("+start+", "+end+")";
    }
}
public class SubSort{
    private static int findLeft(int[] num){
        int i =1;
        for(; i<num.length;i++){
            if(num[i-1] > num[i])
                break;
        }
        return i-1;   
    }
    private static int findRight(int[] num){
        int i =num.length-1;
        for(; i>0;i--){
            if(num[i] < num[i-1])
                break;
        }
        return i;   
    }
    private static int findStart(int[] num, int left, int value){
        int i=0;
        for(; i<=left; i++){
            if(num[i] > value)
                break;
        }
        return i;
    } 
    private static int findEnd(int[] num, int right, int value){
        int i=right;
        for(; i<num.length;i++){
            if(num[i] > value)
                break;
        }
        return i-1;
    }
    public static Result findUnsortedSequence(int[] num){
        int left = findLeft(num);
        int right = findRight(num);
        System.out.println(left+","+right);
        if(left > right){
            return new Result(-1,-1);
        }
        Arrays.sort(num,left+1,right);
        int min = Math.min(num[right],num[left+1]);
        int max = Math.max(num[left],num[right-1]);
        int start=findStart(num,left,min);
        int end=findEnd(num,right,max);
        return new Result(start,end);
    }
    public static void main(String[] args) {
      int num[] = {5,4,3,2,1};
      System.out.println(findUnsortedSequence(num));
    }
}