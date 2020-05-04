public class MajorityElement{
    private static int getPossibleCandidate(int[] array){
        int curMajority= 0;
        int count = 0;
        for(int i=0; i<array.length; i++){
            if(count == 0){
                curMajority = array[i];
            }
            if(curMajority == array[i]){
                count++;
            }else{
                count--;
            }
        }
        return curMajority;
    }
    private static boolean valid(int[] array, int n){
        int count=0;
        for(int i=0; i<array.length; i++){
            if(array[i] == n){
                count++;
            }
        }
        return count > (array.length/2);
    }
    public static int getMajorityElement(int[] array){
        int n = getPossibleCandidate(array);
        return valid(array, n) ? n : -1;
    }
    public static void main(String[] args) {
        int array[] = {1,2,3,2,2,4,3,3,3};
        System.out.println(getMajorityElement(array));
    }
}