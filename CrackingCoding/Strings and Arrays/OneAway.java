public class OneAway{
    public static boolean isReplace(String s1, String s2){
        boolean isDiff =false;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i) ){
                if(isDiff){
                    return false;
                }
                isDiff = true;
            }
        }
        return true;
    }
    public static boolean isEdit(String big, String small){
        if((big.length() - small.length())>1)
            return false;
        int j=0;
        for(int i=0;i<small.length();i++){
            if(big.charAt(j) != small.charAt(i)){
                if(i!=j){
                    return false;
                }
                j++;
            }
            j++;
        }
        return true;
    }
    public static boolean isOneEditAway(String s1, String s2){
        if(s1.length() == s2.length()){
            return isReplace(s1,s2);
        }else if(s1.length() > s2.length()){
            return isEdit(s1,s2);
        }
        return isEdit(s2,s1);
    }
    public static void main(String[] args) {
        System.out.println(isOneEditAway("pale","bale"));
    }
}