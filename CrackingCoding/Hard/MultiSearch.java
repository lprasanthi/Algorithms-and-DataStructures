import java.util.*;
import java.util.List;
class Trie{
    public char value;
    public Trie children[];
    public boolean isWord;
    public Trie(char value){
        this.value = value;
        children = new Trie[26];
        Arrays.fill(children, null);
        isWord = false;
    }
    
    public void addWord(String word){
        Trie current = this;
        for(int i=0; i<word.length(); i++){
            Trie children[] = current.children;
            char cur = word.charAt(i);
            int index = cur - 'a';
            if(children[index] == null){
                children[index] = new Trie(cur);
            }
            current = children[index];
        }
        current.isWord = true;
    }
    public Trie child(char s){
        int index = s-'a';
        return this.children[index];
    }
    public String toString(){
        String s = "\n"+value+" ";
        for(int i=0; i<26; i++){
            if(children[i] != null)
                s= s+children[i].value+", ";
        }
        return s+ "  ";
    }
}
public class MultiSearch{
    private static Trie buildTrie(String[] set){
        Trie root = new Trie('$');
        for(int i=0; i<set.length; i++){
            root.addWord(set[i]);
        }
        return root;
    }
    private static List<String> findWordsAt(Trie root, String word, int index){
        List<String> result = new ArrayList<String>();
        for(int i = index; i<word.length(); i++){
            char s = word.charAt(i);
            root = root.child(s);
            if(root == null){
                return result; 
            }
            if(root.isWord){
                String subWord = word.substring(index, i+1);
                result.add(subWord);
            } 
        }
        return result;
    }
    public static Map<String, List<Integer>> search(String[] set, String word){
        Trie root = buildTrie(set);
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for(int i=0; i<word.length();i++){
            List<String> list = findWordsAt(root,word,i);
            for(String item: list){
                if(map.containsKey(item)){
                    List<Integer> positions = map.get(item);
                    positions.add(i);
                }else {
                    List<Integer> positions = new ArrayList<Integer>();
                    positions.add(i);
                    map.put(item, positions);
                }
            } 
        }
        return map;
    }
    public static void main(String[] args) {
        String[] s = {"is", "ppi", "hi", "sis", "i", "ssippi"};
        String word = "mississippi";
        Map<String, List<Integer>> result = search(s, word);
        System.out.println(result);
    }
}