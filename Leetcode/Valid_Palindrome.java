public class Valid_Palindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]|[ _]", "");
        String palindromo = s;
        for (int i = 0; i < s.length(); i++) {
            palindromo = palindromo.replace(s.charAt(i), s.charAt(s.length() - 1 - i));
            System.out.println(palindromo);
        }
        return palindromo.equals(s);
    }

    public static void main(String[] args) {
        Valid_Palindrome v = new Valid_Palindrome();
        System.out.println(v.isPalindrome("ab_a"));
    }
}
