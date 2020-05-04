import java.util.*;
public class GroupAnagrams{
    private static String sortString(String s){
        char sArray[]=s.toCharArray();
        Arrays.sort(sArray);
        String sortedString=String.valueOf(sArray);
        return sortedString;
    }
    public static String[] sortByAnagrams(String[] arr){
       Map<String,List<String>> map=new HashMap<String,List<String>>();
       for(int i=0;i<arr.length;i++){
           String key = sortString(arr[i]);
           List<String> list = map.getOrDefault(key,new ArrayList<String>());
           list.add(arr[i]);
           map.put(key,list);
       }
       String anagrams[]=new String[arr.length];
       int i=0;
       for(String key:map.keySet()){
           List<String> list=map.get(key);
           for(String each:list){
                anagrams[i]= each;
                i++;
           }
       }
       return anagrams;
    }
    public static void main(String[] args) {
        String arr[]={"race","pen","pencil","cart","care","ract","acre"};
        String sortedarr[]=sortByAnagrams(arr);
        for(int i=0;i<sortedarr.length;i++)
            System.out.println(sortedarr[i]);
    }
}