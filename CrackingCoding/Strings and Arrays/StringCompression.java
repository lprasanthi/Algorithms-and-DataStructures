public class StringCompression{
    public static int compressedLength(String str){
        int compressedCount =0;
        for(int i=0; i< str.length(); ){
            int count = countConsecutive(str,i);
            int countLen = String.valueOf(count).length();
            compressedCount = compressedCount+countLen+1;
            i=i+count;
        }
        return compressedCount;
    }

    private static int countConsecutive(String str, int start){
        int count =1;
        for(int i=start; i<(str.length()-1) && (str.charAt(i) == str.charAt(i+1)); i++){
            count++;
        }
        return count;
    }
    public static String compressString(String str){
        if(compressedLength(str)>= str.length()){
            return str;
        }
        StringBuilder compressed = new StringBuilder();
        for(int i=0; i< str.length(); ){
            int count = countConsecutive(str,i);
            compressed = compressed.append(str.charAt(i)).append(String.valueOf(count));
            i=i+count;
        }
        return compressed.toString();
    }
    public static void main(String[] args) {
        System.out.println(compressString("aabbccc"));
    }
}