import java.util.*;
import java.util.List;
class Document implements Comparable<Document>{
    public Integer id;
    public int[] words;
    public Document(Integer id, int[] words){
        this.id = id;
        this.words = words;
    }
    @Override
    public String toString() {
        return ""+id;
    }
 
    @Override
    public int compareTo(Document o) {
        return this.id.compareTo(o.id);
    }

    public int length(){
        return this.words.length;
    }
}

class DocPair{
    public int id1;
    public int id2;
    public DocPair(int id1, int id2) {
        this.id1=id1;
        this.id2=id2;
    }
    @Override
    public String toString() {
        return id1+", "+id2;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DocPair d = (DocPair) o;
        return id1 == d.id1 && id2 == d.id2;
    }

    @Override
    public int hashCode() {
        return id1 * 31 + id2;
    }

}
public class SparseSimilarity{
    public static Map<Integer, List<Integer>> mapDataToDocId(List<Document> docs) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(Document doc : docs){
            int[] words = doc.words;
            for(int i=0; i<words.length; i++){
                if(!map.containsKey(words[i])){
                    map.put(words[i], new ArrayList<Integer>());
                }
                List<Integer> ids = map.get(words[i]);
                ids.add(doc.id);
            } 
        }
        return map;
    }
    public static void addDocPairs(List<Integer> docIds, Map<DocPair, Integer> pairs){
        Collections.sort(docIds);
        // System.out.println(docIds);
        for(int i=0; i< docIds.size();i++){
            for(int j=i+1; j<docIds.size();j++){
                DocPair p = new DocPair(docIds.get(i), docIds.get(j));
                if(!pairs.containsKey(p)){
                    pairs.put(p,0);
                }
                int count = pairs.get(p);
                count++;
                pairs.put(p,count);
            }
        }
    }
    public static Map<DocPair, Integer> intersection(List<Document> docs) {
        Map<Integer, List<Integer>> map = mapDataToDocId(docs);
        // System.out.println(map);
        Map<DocPair, Integer> pairs= new HashMap<DocPair, Integer>();
        for(int key : map.keySet()){
            List<Integer> docIds= map.get(key);
            if(docIds.size() > 1){
                addDocPairs(docIds, pairs);
            }
        }
        return pairs;
    }
    // Could be optimized by adding the entire object to the map key
    public static Map<Integer, Integer> createLengthMap(List<Document> documents){
        Map<Integer, Integer> lengths = new HashMap<Integer, Integer>();
        for(Document doc:documents){
            lengths.put(doc.id, doc.length());
        }
        return lengths;
    }
    public static Map<DocPair, Double> sparseSimilarity(List<Document> documents){
        Map<DocPair, Integer> map = intersection(documents);
        Map<Integer, Integer> lengths = createLengthMap(documents);
        Map<DocPair, Double> similarity = new HashMap<DocPair, Double>();
        for(Map.Entry<DocPair, Integer> entry: map.entrySet()){
            DocPair pair = entry.getKey();
            double intersection = (double) entry.getValue();
            double union = (double)(lengths.get(pair.id1) + lengths.get(pair.id2))-intersection;
            double similarityIndex = intersection/union;
            similarity.put(pair, similarityIndex);
        }
        return similarity;
    }
    public static List<Document> getDocuments(){
        List<Document> docs = new ArrayList<Document>();
        int a[] = {14,15,100,9,3};
        int b[] = {32,1,9,3,5};
        int c[] = {15,29,2,6,8,7};
        int d[] = {7,10};
        docs.add(new Document(12, a));
        docs.add(new Document(13, b));
        docs.add(new Document(14, c));
        docs.add(new Document(15, d));
        return docs;
    }

    public static void main(String[] args) {
        List<Document> docs = getDocuments();
        Map<DocPair, Double> similarity = sparseSimilarity(docs);
        System.out.println(similarity);
    }
}