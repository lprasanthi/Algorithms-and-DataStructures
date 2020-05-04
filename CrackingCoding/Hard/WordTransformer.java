import java.util.*;
import java.util.List;
public class WordTransformer{
    public static boolean isOneDistance(String one, String other){
        if(one.equals(other) || one.length() != other.length()){
            return false;
        }
        int count = 0;
        for(int i=0; i<one.length(); i++){
            if(count > 1){
                return false;
            }
            if(one.charAt(i) != other.charAt(i)){
                count++;
            }
        }
        return count == 1;
    }
    public static Map<String, List<String>> buildMap(String[] dictionary){
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i=0; i<dictionary.length; i++){
            String key = dictionary[i];
            List<String> oneDist= new ArrayList<String>();
            for(int j=0; j<dictionary.length;j++){
                if(isOneDistance(dictionary[i],dictionary[j])){
                    oneDist.add(dictionary[j]);
                }
            }
            map.put(key, oneDist);
        }
        return map;
    }
    private static boolean transform(String start, String end, Map<String, List<String>> dictionary, List<String> words, Set<String> visited){
        boolean found=false;
        if(visited.contains(start)){
            return false;
        }
        if(start == end){
            words.add(start);
            return true;
        }
        visited.add(start);
        List<String> connected = dictionary.get(start);

        for(String s : connected){
            found = transform(s, end, dictionary, words, visited);
            if(found){
                words.add(start);
                return true;
            }
        }
        return found;
    }
    public static List<String> transform(String start, String end, Map<String, List<String>> dictionary){
        List<String> words = new ArrayList<String>();
        Set<String> set = new HashSet<String>();
        transform(start,end,dictionary,words,set);
        return words;
    }
    public static void main(String[] args) {
        String start = "Damp";
        String end= "Like";
        String[] dictionary = {"Damp","Lamp","Pimp","Dimp","Pamp","Limp","Lime","Sime","Rime","Like","Yike","Sike"};
        Map<String, List<String>> map = buildMap(dictionary);
        List<String> words = transform(start, end, map);
        System.out.println(words);
    }
}