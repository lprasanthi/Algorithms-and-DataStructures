import java.util.*;
public class Shuffle{
    private static int random(int bound){
        Random rand = new Random();
        return rand.nextInt(bound); // generates 0 to bound-1
    }
    public static int[] shuffleDeck(int[] cards){
        for(int i=cards.length -1; i>0; i--){
            int k = random(i);
            int temp = cards[i];
            cards[i] = cards[k];
            cards[k] = temp;
        }
        return cards;
    }
    public static void main(String[] args) {
        int[] cards = new int[52];
        for(int i =0; i< 52;i++){
            cards[i] = i;
        }
        shuffleDeck(cards);
        for(int i =0; i< 52;i++){
            System.out.print(cards[i]+", ");
        }
        System.out.println();
    }
}