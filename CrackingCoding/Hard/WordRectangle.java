import java.util.List;
import java.util.*;

class Rectangle{
    public List<String> words;
    public int size;
    public Rectangle(){
        this.words = new ArrayList<String>();
        size =0;
    }
    public Rectangle(List<String> words){
        this.words = words;
        size = this.words.size();
    }
    public void insert(String word){
        this.words.add(word);
        size++;
    }
    public String toString(){
        return words.toString();
    }
}
class Trie{
    char data;
    Trie[] children;
    boolean isWord;
    public Trie(char data){
        this.data = data;
        isWord= false;
        children = new Trie[26];
        Arrays.fill(children, null);
    }
    public void insert(String word){
        Trie current = this;
        for(int i=0; i<word.length();i++){
            char data = word.charAt(i);
            int index = data - 'a';
            Trie[] children = current.children;
            if(children[index] == null)
                children[index] = new Trie(data);
            current = children[index];
        }
        current.isWord = true;
        return;
    }
    public boolean search(String word){
        Trie current = this;
        for(int i=0; i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(current.children[index] != null){
                current = current.children[index];
            }else{
                return false;
            }
        }
        return current.isWord;
    }
    public boolean contains(String word){
        Trie current = this;
        for(int i=0; i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(current.children[index] != null){
                current = current.children[index];
            }else{
                return false;
            }
        }
        return true;
    }
    public void traverse(Trie current, String partial, List<String> list){
        if(current == null){
            return;
        }
        char data = current.data;
        if(current.isWord){
            list.add(partial+data);
        }
        for(int i=0; i<26; i++){
            Trie child = current.children[i];
            traverse(child,partial+data , list); 
        } 
    }
    private List<String> traverse(){
        List<String> list = new ArrayList<String>();
        traverse(this, "", list);
        return list;
    }
    public List<String> toStrings(){
        return this.traverse();
    }
    public String toString(){
        return ""+this.data;
    }
}
class Dictionary{
    public List<List<String>> words;
    public List<Trie> groups;
    public Dictionary(List<List<String>> words, List<Trie> groups){
        this.words = words;
        this.groups = groups;
    }
    public String toString(){
        String s ="";
        for(Trie trie: groups)
           s= s+ trie.toStrings();
        return "GROUPS: \n"+s+" \n WORDS: \n"+words;
    }
}

public class WordRectangle{
    public static List<List<String>> groupWords(String[] dictionary){
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        List<List<String>> groups = new ArrayList<List<String>>();
        int max =0;
        for(int i=0; i<dictionary.length;i++){
            int index = dictionary[i].length();
            if(map.containsKey(index)){
                List<String> words= map.get(index);
                words.add(dictionary[i]);
            }else{
                List<String> words = new ArrayList<String>();
                words.add(dictionary[i]);
                map.put(index, words);
            }
            if(index > max){
                max = index;
            }
        }
        for(int i=1; i<=max; i++){
            if(!map.containsKey(i)){
                map.put(i, new ArrayList<String>());
            }
            groups.add(map.get(i));
        }
        return groups;
    }
    public static List<Trie> group(String[] dictionary){
        Map<Integer, Trie> map = new HashMap<Integer, Trie>();
        List<Trie> groups = new ArrayList<Trie>();
        int max =0;
        for(int i=0; i<dictionary.length;i++){
            int index = dictionary[i].length();
            if(map.containsKey(index)){
                Trie tree= map.get(index);
                tree.insert(dictionary[i]);
            }else{
                Trie words = new Trie('$');
                words.insert(dictionary[i]);
                map.put(index, words);
            }
            if(index > max){
                max = index;
            }
        }
        for(int i=1; i<=max; i++){
            if(!map.containsKey(i)){
                map.put(i, new Trie('$'));
            }
            groups.add(map.get(i));
        }
        return groups;
    }
    // pre-processing step
    private static Dictionary preprocess(String[] dict){
        List<Trie> groups = group(dict);
        List<List<String>> words = groupWords(dict);
        return new Dictionary(words, groups);
    }
    private static String[] prefixes(List<String> words, int length){
        String[] list= new String[length];
        for(int i=0; i<length; i++){
            String pre="";
            for(String word: words){
                pre = pre+word.charAt(i);
            }
            list[i] = pre;
        }
        return list;
    }
    private static boolean isValid(List<String> words, String word, Trie tree){
        String[] prefixList = prefixes(words, word.length());
        for(int i=0; i<prefixList.length; i++){
            String prev = prefixList[i];
            char current = word.charAt(i);
            if(!tree.contains(prev+current))
                return false;
        }
        return true;
    }

    private static List<String> ValidWords(List<String> currentList, List<String> lengthWords, Trie tree){
        List<String> list = new ArrayList<String>();
        if(currentList.size() == 0){
            return lengthWords;
        }
        for(String word:lengthWords){
            if(isValid(currentList, word, tree)){
                list.add(word);
            }
        }
        return list;
    }
    public static boolean makePartialRectangle(List<String> allWords, Trie tree, List<String> currentWords, int count){
        if(currentWords.size() == count){
            return true;
        }
        List<String> list = ValidWords(currentWords, allWords, tree);
        for(String word: list){
            currentWords.add(word);
            if(!makePartialRectangle(allWords, tree, currentWords, count)){
                int index = currentWords.size() -1;
                currentWords.remove(index);
            }else{
                return true;
            }
        }
        return false;
    }
    public static Rectangle makeRectangle(Dictionary dictionary, int length, int breadth){
        List<String> lengthWords = dictionary.words.get(length-1);
        Trie tree = dictionary.groups.get(breadth-1);
        List<String> currentList = new ArrayList<String>();
        
        if(makePartialRectangle(lengthWords, tree, currentList , breadth))
            return new Rectangle(currentList);
        return null;
    } 
    public static Rectangle getRectangle(String[] words){
        Dictionary dictionary = preprocess(words);
        int maxLength = dictionary.words.size();
        int maxArea = maxLength * maxLength;
        for(int i=maxArea; i>0; i--){
            for(int j=maxLength; j>0; j--){
                if(i%j == 0 && i/j <= maxLength){
                    int length = j;
                    int breadth = i/j;
                    Rectangle rectangle = makeRectangle(dictionary,length, breadth);
                    if(rectangle != null)
                        return rectangle;  
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        String dictionary[]={"p", "e", "n","po","o", "pen", "green", "queen","please","peon","gowns","roses",
        "oodle","epsy","roots","words","ntaet","ssprs","elders", "nests","edrap", "elder",
        "enclose","ncloseat","closeat","orteste","enco","nclr","clot","lose","oses","seat","este", "grassp","ropple",
        "eottse","etarsk","nsavke","aptaa","sptrv","slssk","peeke"};
        Rectangle r = getRectangle(dictionary);
        System.out.println(r);
    }
}
