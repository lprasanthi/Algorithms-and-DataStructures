import java.util.*;
public class WordFrequency{
    private static Map<String,Integer> getDisctionaryMap(String dictionary){
        String[] words = dictionary.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        Map<String, Integer> map = new HashMap<String, Integer>(); 
        for(String word : words){
            int count = map.getOrDefault(word,0);
            map.put(word,count+1);
        }
        return map;
    }
    public static int getFrequency(String dictionary, String word){
        Map<String, Integer> map = getDisctionaryMap(dictionary);
        return map.getOrDefault(word.toLowerCase(), 0);
    }
    public static void main(String[] args) {
        String dictionary = "This is just a sample content. It isn't really a dictionary. Dictionary has a lot more words.";
        String word = "dictionary";
        System.out.println(getFrequency(dictionary, word));
    }
}