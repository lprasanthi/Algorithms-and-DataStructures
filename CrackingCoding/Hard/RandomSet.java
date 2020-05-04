import java.util.*;
public class RandomSet{
    private static int random(int bound){
        Random rand = new Random();
        return rand.nextInt(bound); // generates 0 to bound-1
    }
    public static int[] pickMSet(int[] cards, int m){
        int set[] = new int[m];
        int j=0;
        int count = cards.length - m;
        for(int i=cards.length -1; i>=count; i--){
            int k = random(i);
            int temp = cards[i];
            cards[i] = cards[k];
            set[j++] = cards[k];
            cards[k] = temp;
        }
        return set;
    }
    public static void main(String[] args) {
        int[] cards = new int[52];
        for(int i =0; i< 52;i++){
            cards[i] = i;
        }
        int[] set = pickMSet(cards, 8);
        for(int i =0; i< 8;i++){
            System.out.print(set[i]+", ");
        }
        System.out.println();
    }
}