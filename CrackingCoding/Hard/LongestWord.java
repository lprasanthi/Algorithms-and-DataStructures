import java.util.*;
public class LongestWord {
    private static String[] split(String word, int index){
        String[] result = new String[2];
        result[0] = word.substring(0, index+1);
        if(index+1 < word.length())
            result[1]= word.substring(index+1);
        return result;
    }
    private static boolean canBuild(String word, Map<String,Boolean> map, boolean isOriginal) {
        if(map.containsKey(word) && !isOriginal){
            return true;
        }
        for(int i=0; i<word.length(); i++){
            String result[] = split(word, i);
            String left = result[0];
            if(map.containsKey(left)){
                String right = result[1];
                boolean isRight = canBuild(right, map, false);
                if(isRight)
                    return true;
                map.put(right, false);
            }
        }
        return false;
    }
    private static String longestFrom(String[] words, Map<String, Boolean> map){
        for(String word : words){
            if(canBuild(word, map, true))
                return word;     
        }
        return null;
    }
    public static String longestFrom(String[] words){
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        for(String word: words){
            map.put(word, true);
        }
        Arrays.sort(words, (a,b) -> b.length() - a.length());
        return longestFrom(words, map);
    }
    public static void main(String[] args) {
        String words[] = {"misissippi","test","miss","mis","pi","sip","is","sippi"};
        // String test[] = longestFrom(words);
        // for(int i=0; i<test.length;i++)
        System.out.println(longestFrom(words));
    }
}