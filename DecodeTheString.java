import java.util.*;
class DecodeTheString{
    static String decodeString(String string){

        Stack<Integer> num = new Stack<Integer>();
        Stack<String> str = new Stack<String>();
        
        for(int i=0;i<string.length();i++){
            if(Character.isDigit(string.charAt(i))){
                num.push(Integer.parseInt(String.valueOf(string.charAt(i))));
            }
            int start = i;
            while(Character.isAlphabetic(string.charAt(i))){
                i++;
            }
            if(start!=i){
                str.push(string.substring(start, i));
                i=i-1;
            }
            
            
        }
        for(int s : num){
            System.out.println(s);
        }

        for(String s : str){
            System.out.println(s);
        }
        return "HI";
    }
    public static void main(String arg[]){
        String str = "3[b2[ca]]";
        String ans = decodeString(str);
    }
}
