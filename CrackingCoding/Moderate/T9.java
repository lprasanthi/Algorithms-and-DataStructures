import java.util.*;
class TrieNode{
    public char val;
    public TrieNode[] children=new TrieNode[26];
    public boolean isWord;
    public TrieNode(char val){
        this.val=val;
        this.isWord=false;
        for(int i=0;i<26;i++){
            children[i]=null;
        }
    }
}
class Trie {
    public TrieNode root;

    public Trie() {
        root=new TrieNode(' ');
    }
    
    public void add(String word) {
        TrieNode cur=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            int index=c-'a';
            if(cur.children[index] == null){
                TrieNode temp=new TrieNode(c);
                cur.children[index] = temp;
            }
            cur=cur.children[index];
        }
        cur.isWord=true;
    }
    
    public boolean search(String word) {
        TrieNode cur=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            int index=c-'a';
            if(cur.children[index] == null)
                return false;
            cur=cur.children[index];
        }
        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur=root;
        for(int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            int index=c-'a';
            if(cur.children[index] == null)
                return false;
            cur=cur.children[index];
        }
        return true;
    }
}
public class T9{
    private static Trie getDictionary(){
        Trie dictionary = new Trie();
        dictionary.add("tree");
        dictionary.add("used");
        dictionary.add("trunk");
        dictionary.add("apple");
        dictionary.add("user");
        dictionary.add("uses");
        return dictionary;
    }
    private static String[] keyPad(){
        String map[]= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        return map;
    }
    private static List<String> getValidSuggestions(String input, int start, String prefix, Trie dictionary, String[] map){
        List<String> words = new ArrayList<String>();
        if(start == input.length()){
            if(dictionary.search(prefix)){
                words.add(prefix);
            }
            return words;
        }
        int index = Integer.parseInt(String.valueOf(input.charAt(start)));
        String keys = map[index];
        for(int i=0; i<keys.length(); i++){
            char c = keys.charAt(i);
            String newPrefix = prefix+Character.toString(c);
            if(dictionary.startsWith(newPrefix)){
               List<String> suggestions = getValidSuggestions(input,start+1,newPrefix,dictionary,map);
               words.addAll(suggestions);
            }
        }
        return words;
    }
    public static List<String> getValidSuggestions(String input){
        Trie dictionary = getDictionary();
        String map[] = keyPad();
        return getValidSuggestions(input,0,"",dictionary, map);
    }
    public static void main(String[] args) {
        String input = "8733";
        List<String> suggestions = getValidSuggestions(input);
        System.out.println(suggestions);
    }
}