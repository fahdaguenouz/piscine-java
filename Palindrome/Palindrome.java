public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s==null){
            return null;
        }
        String reverse="";
        for (int i=s.length()-1;i>=0;i--){
            char letter = s.charAt(i);
            reverse+=letter;
        }
        reverse.toLowerCase();
// System.out.println(reverse);
// System.out.println(s);
// System.out.println(s.toLowerCase());

        return s.toLowerCase().equals(reverse.toLowerCase());
         
    }
}