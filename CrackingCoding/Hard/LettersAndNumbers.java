import java.util.*;
public class LettersAndNumbers{
    private static int[] findDiff(char[] array){
        int delta = 0;
        int[] diffArray = new int[array.length];
        for(int i=0; i<array.length; i++){
            if(Character.isLetter(array[i])){
                delta++;
            }else if(Character.isDigit(array[i])){
                delta--;
            }
            diffArray[i] = delta;
        }
        return diffArray;
    }
    private static int[] findRange(int[] diffArray){
        int[] range = {0,0};
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<diffArray.length; i++){
            if(!map.containsKey(diffArray[i])){
                map.put(diffArray[i], i);
            }else{
                int start = map.get(diffArray[i]);
                int end = i;
                int diff = end - start;
                if(diff > range[1] - range[0]){
                    range[0] = start;
                    range[1] = end;
                }
            }
        }
        return range;
    }
    public static char[] findLongestSubArray(char[] array){
        int[] deltas = findDiff(array);
        int[] range = findRange(deltas);
        return Arrays.copyOfRange(array, range[0]+1, range[1] + 1);
    }
    public static void main(String[] args) {
        String str = "aaaa11a11aa1aa1aaaaa";
        char[] lettersNum = new char[str.length()];
        for(int i=0; i<str.length(); i++){
            lettersNum[i]= str.charAt(i);
        }
        char[] result = findLongestSubArray(lettersNum);
        System.out.println(result);
    }
}