public class PalindromePermutation{
    private static boolean isOnlyOneSet(int hash){
        return (hash & (hash-1)) == 0;
    }
    public static boolean isPalindromePerm(String s){
        int hash=0;
        for(int i=0;i<s.length();i++){
            int val = s.charAt(i)-'a';
            int mask= 1<<val;
            hash = hash ^ mask;
        }
        return isOnlyOneSet(hash);
    }
    public static void main(String[] args) {
        System.out.println(isPalindromePerm("abbacde"));
    }
}