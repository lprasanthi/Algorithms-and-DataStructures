import java.util.Arrays;

public class CheckPermutation{
    private static String sort(String s){
        char[] a= s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
    public static boolean isPermutation(String first, String other){
        if(first.length() != other.length()){
            return false;
        }
        return sort(first).equals(sort(other));
    }
    public static boolean isPermutationSpace(String first, String second){
        if(first.length() != second.length()){
            return false;
        }
        int[] hashTable= new int[128];
        for(int i=0; i< first.length(); i++){
            hashTable[first.charAt(i)]++;
        }
        for(int i=0; i< second.length(); i++){
            hashTable[second.charAt(i)]--;
            if(hashTable[second.charAt(i)] < 0){
                return false;
            }
        }
        return true;
        
    }
    public static void main(String[] args) {
       System.out.println(isPermutationSpace("abc", "cba"));
    }
}