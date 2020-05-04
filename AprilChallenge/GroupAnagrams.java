// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3288/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map=new HashMap<String,ArrayList<String>>();
        for(int i=0;i<strs.length;i++){
            char key[]=strs[i].toCharArray();
            Arrays.sort(key);
            String sortedKey=String.valueOf(key);
            if(!map.containsKey(sortedKey)) map.put(sortedKey, new ArrayList<String>());
            map.get(sortedKey).add(strs[i]);
        }
        return new ArrayList<List<String>>(map.values());
     }
}