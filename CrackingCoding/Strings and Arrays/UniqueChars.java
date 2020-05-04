import java.util.Arrays;

public class UniqueChars{
    public static boolean isUnique(String str){
        boolean[] hash = new boolean[256];
        Arrays.fill(hash,false);
        String trimmed = str.trim();
        for(int i=0; i<trimmed.length(); i++){
            int ascii=trimmed.charAt(i);
            if(hash[ascii] == true){
                return false;
            }
            hash[ascii] = true;
        }
        return true;
    }
    // works only for a-z characters
    public static boolean isUniqueOptimal(String str){
        int checker=0;
        String trimmed = str.trim();
        for(int i=0;i<trimmed.length();i++){
            int val = trimmed.charAt(i)-'a';
            //set val position to 1 and rest to 0
            int mask = 1<<val;
            if(checker & mask > 0){
                return false;
            }
            checker = checker | mask;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isUnique("   "));
    }
}