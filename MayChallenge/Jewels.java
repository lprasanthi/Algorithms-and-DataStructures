public class Jewels {
    public int numJewelsInStones(String J, String S) {
        int map[]=new int[58];
        for(int i=0; i<J.length(); i++)
            map[J.charAt(i)-'A']=1;
        int count=0;
        for(int i=0; i<S.length(); i++){
            if(map[S.charAt(i)-'A'] == 1)
                count++;
        }
        return count;
    }
}