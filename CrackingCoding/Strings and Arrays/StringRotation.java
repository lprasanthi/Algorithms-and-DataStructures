public class StringRotation{
    public static boolean isRotation(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        String str11= str1+str1;
        return str11.contains(str2);
    }
    public static void main(String[] args) {
        System.out.println(isRotation("water","erwat"));
    }
}