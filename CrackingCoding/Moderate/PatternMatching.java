public class PatternMatching{
    private static int count(String pattern, char a){
        int count =0;
        for(int i=0; i<pattern.length();i++){
            if(pattern.charAt(i) == a){
                count++;
            }
        }
        return count;
    }
    private static int find(String pattern, char c){
        for(int i=0; i<pattern.length(); i++){
            if(pattern.charAt(i) == c)
                return i;
        }
        return -1;
    }
    private static String buildPattern(String pattern, String a, String b){
        String s= "";
        for(int i=0; i<pattern.length(); i++){
            if(pattern.charAt(i) == 'a'){
                s = s+a;
            }else{
                s=s+b;
            }
        }
        return s;
    }
    public static boolean match(String pattern, String value){
        char a = pattern.charAt(0);
        char b = (a == 'a') ? 'b' : 'a';
        int aCount = count(pattern, a);
        int bCount = count(pattern, b);
        int bStart = find(pattern, b);
        // form the equation aCount*a + bCount*b = value.length()
        int length = value.length();
        System.out.println(length+","+pattern.length());
        for(int i=1; i*aCount<length; i++){
            // int a =i;
            int totalB = length - (aCount*i);
            int j = totalB/bCount;
            if(totalB % bCount == 0){
                String aString = value.substring(0,i);
                int bIndex = bStart*i;
                String bString = value.substring(bIndex, bIndex+j);
                String newPattern = buildPattern(pattern,aString,bString);
                if(value.equals(newPattern)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
       String pattern = "aabab";
       String value = "catcatgocatgo";
       System.out.println(match(pattern, value)); 
    }
}