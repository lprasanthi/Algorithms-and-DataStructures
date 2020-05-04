public class EnglishInt{
    private static String convert(int num){
        String[] ones = {"","One","Two","Three","Four","Five","Six","Seven",
        "Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen",
        "Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] tens = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        if(num < 20)
            return ones[num];
        else if(num < 100){
            String word = convert(num%10);
            if(word.isEmpty()) return tens[num/10];
            else return tens[num/10] +" "+convert(num%10);
        }else{
            String word = convert(num%100);
            if(word.isEmpty()) return ones[num/100]+" Hundred";
            return ones[num/100]+" Hundred "+word;
        }
    }
    public static String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        String[] bigs = {""," Thousand "," Million "," Billion "};
        String words="";
        int i=0;
        while(num > 0){
            String word = convert(num%1000);
            if(!word.isEmpty())
                words = word+bigs[i]+words;
            num = num/1000;
            i++;
        }
        return words.trim();
        
    }
    public static void main(String[] args) {
        int a = 19323984;
        String s = numberToWords(a);
        System.out.println(s);
    }
}