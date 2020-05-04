// https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/

class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int map[]=new int[26];
        for(int i=0; i<magazine.length();i++){
            int index= magazine.charAt(i)-'a';
            map[index]++;
        }
        for(int i=0; i<ransomNote.length();i++){
            int index= ransomNote.charAt(i)-'a';
            map[index]--;
            if(map[index]== -1)
                return false;
        }
        return true;
    }
}