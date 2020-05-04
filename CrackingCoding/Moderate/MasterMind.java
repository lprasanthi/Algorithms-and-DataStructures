class Result{
    public int hits;
    public int pseudoHits;
    public Result(){
        this.hits = 0;
        this.pseudoHits = 0;
    }
    public String toString(){
        return "Hits: "+hits+", Pseudo Hits: "+pseudoHits;
    }
}
public class MasterMind{
    // public static int getHits(String solution, String guess){
    //     int hits=0;
    //     for(int i=0; i<solution.length(); i++){
    //         if(solution.charAt(i) == guess.charAt(i))
    //             hits++;
    //     }
    //     return hits;
    // }
    private static int map(char c){
        switch(c){
            case 'r':
            case 'R':
                return 0;
            case 'g':
            case 'G':
                return 1;
            case 'B':
                return 2;
            case 'Y':
                return 3;
            default:
                return -1;
        }
    }
    public static Result getHits(String solution, String guess){
        Result result = new Result();
        int map[] = {0,0,0,0};
        for(int i=0; i<solution.length();i++) {
            int index = map(solution.charAt(i));
            if(guess.charAt(i) != solution.charAt(i) && index != -1){
                map[index]++; 
            }
        }
        for(int i=0; i<guess.length(); i++){
            if(guess.charAt(i) != solution.charAt(i)){
                int index = map(guess.charAt(i));
                if(index != -1 && map[index] > 0){
                    result.pseudoHits++;
                    map[index]--;
                }
            }else {
                result.hits++;
            }
        }
        return result;
    }
    public static Result play(String solution, String guess){
        if(solution.length() != guess.length())
            return null;
        Result res = getHits(solution,guess);
        return res;
    }
    public static void main(String[] args) {
        String solution = "RGBY";
        String guess= "GGRR";
        Result result = play(solution,guess);
        System.out.println(result);
    }
}