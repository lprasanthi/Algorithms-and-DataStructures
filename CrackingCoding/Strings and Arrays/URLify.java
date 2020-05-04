public class URLify{
    private static int countSpaces(char[] str, int trueLength){
        int spaces =0;
        for(int i=0; i<trueLength;i++){
            if(str[i] == ' '){
                spaces++;
            }
        }
        return spaces;
    }
    public static String replaceSpaces(char[] str, int trueLength){
        int spaces = countSpaces(str,trueLength);
        int n= "%20".length();
        int length = trueLength+(n-1)*spaces;
        trueLength--;
        int i= length-1;
        while(i>0){
            if(str[trueLength] == ' ') {
                str[i]='0';
                str[i-1]='2';
                str[i-2]='%';
                i=i-3;
            }else{
                str[i] = str[trueLength];
                i--;
            } 
            trueLength--;
        }
        return new String(str);
    }
    public static void main(String[] args) {
        String s = "Hello Kitty";
        char[] b = new char[100];
        for(int i=0; i<s.length(); i++){
            b[i]=s.charAt(i);
        }
        System.out.println(replaceSpaces(b,s.length()));
    }
}