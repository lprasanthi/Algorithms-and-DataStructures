import java.util.*;
import java.util.List;
class ValidWords{
    public int invalidCount;
    public List<String> words;
    public ValidWords(){
        invalidCount = 100;
        words = new ArrayList<String>();
    }
    public ValidWords(int count){
        invalidCount = count;
        words = new ArrayList<String>();
    }
    public String toString(){
        return words+ ",  "+invalidCount;
    }
    public void add(List<String> words){
        this.words = new ArrayList<String>();
        this.words.addAll(words);
    }
}
public class ReSpace {
    private static Set<String> buildDictionary(){
        Set<String> dictionary = new HashSet<String>();
        dictionary.add("looked");
        dictionary.add("just");
        dictionary.add("like");
        dictionary.add("her");
        dictionary.add("brother");
        return dictionary;
    }
    
    private static ValidWords validSentence(String sentence, Set<String> dictionary, Map<String, ValidWords> memo){
        System.out.println(sentence);
        if(dictionary.contains(sentence)){
            ValidWords result = new ValidWords();
            result.invalidCount = 0;
            result.words.add(sentence);
            return result;
        }
        if(memo.containsKey(sentence)){
            return memo.get(sentence);
        }
        ValidWords words = new ValidWords();
        ValidWords minInvalid = new ValidWords();
        for(int i=0; i<sentence.length()-1; i++){
          String prefix = sentence.substring(0,i+1);
          String remaining = sentence.substring(i+1);
          int invalidCount = dictionary.contains(prefix) ? 0 : prefix.length();
          System.out.println("prefix and remaining: "+prefix+","+remaining);
          ValidWords nextResult = validSentence(remaining, dictionary, memo);
          System.out.println("nextResult for: "+sentence+" is: "+nextResult);  
          invalidCount = invalidCount + nextResult.invalidCount;
          if(invalidCount < minInvalid.invalidCount){
            System.out.println("Valid============");
              minInvalid.invalidCount = invalidCount;
              List<String> list = new ArrayList<String>();
              list.addAll(nextResult.words);
              list.add(prefix);
              minInvalid.add(list);
              System.out.println("prefix sentence and nextresult: "+prefix+","+sentence+", "+nextResult.words);
          }
        }
        memo.put(sentence, minInvalid);
        // System.out.println(sentence+", "+minInvalid);
        return minInvalid;
    }
    public static List<String> validSentence(String sentence, Set<String> dictionary){
        List<String> words = new ArrayList<String>();
        Map<String, ValidWords> memo= new HashMap<String, ValidWords>();
        return validSentence(sentence,dictionary,memo).words;
    }
    public static void main(String[] args) {
        String sentence = "jesslookedjustliketimherbrother";
        Set<String> dictionary= buildDictionary();
        List<String> words =  validSentence(sentence, dictionary);
        System.out.println(words);
    }
}