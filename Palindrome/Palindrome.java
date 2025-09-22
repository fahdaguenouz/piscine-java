public class Palindrome {
    public static boolean isPalindrome(String s) {
        String reverse="";
        for (int i=s.length()-1;i>=0;i--){
            char letter = s.charAt(i);
            reverse+=letter;
        }
        return s.equals(reverse);
         
    }
}