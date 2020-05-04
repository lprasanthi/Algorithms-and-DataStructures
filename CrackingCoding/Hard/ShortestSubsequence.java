import java.util.*;
import java.util.List;
class Range{
    public int start;
    public int end;
    public Range(int start, int end){
        this.start = start;
        this.end = end;
    }
    public String toString(){
        return start+", "+end;
    }
    public int diff(){
        return Math.abs(end-start);
    }
    public int compareTo(Range a){
        return this.diff() - a.diff();
    }
}
public class ShortestSubsequence{
    private static List<List<Integer>> indexLists(int[] seq, int[] subSeq){
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0; i<subSeq.length; i++){
            map.put(subSeq[i], new ArrayList<Integer>());
        }
        for(int i=0; i<seq.length; i++){
            List<Integer> list = map.get(seq[i]);
            if(list != null){
                list.add(i);
            }
        }

        for(int i=0; i<subSeq.length;i++){
            result.add(map.get(subSeq[i]));
        }
        return result;
    }
    private static Range findRange(int[] array){ 
        int min=0;
        int max=0;
        for(int i=0; i<array.length; i++){
            if(array[i] < array[min]){
                min=i;
            }
            if(array[i] > array[max]){
                max=i;
            }
        }
        return new Range(min,max); 
    }
    private static boolean update(List<Integer> list){
        list.remove(0);
        return list.size() == 0;
    }
    public static Range shortestSequenceContaining(int[] seq, int[] subSeq){
        List<List<Integer>> indexes = indexLists(seq, subSeq);
        Range optimalRange = new Range(0, seq.length);
        while(true){
            int[] heads = new int[subSeq.length];
            for(int i=0; i<indexes.size(); i++){
                heads[i] = indexes.get(i).get(0);
            }
            Range rangeIndex = findRange(heads);
            Range cur = new Range(heads[rangeIndex.start], heads[rangeIndex.end]);
            if(cur.diff() < optimalRange.diff()){
                optimalRange = cur;
            }
            if(update(indexes.get(rangeIndex.start))){
                break;
            }
        }
        return optimalRange;
    }
    public static void main(String[] args) {
        int seq[] = {7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};
        int subSeq[] = {1,5,9};
        Range range = shortestSequenceContaining(seq, subSeq);
        System.out.println(range);
    }
}