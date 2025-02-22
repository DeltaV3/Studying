public class Palindrome_Number {

    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        for (int i = 0; i < str.length() - 1; i++) {
            str = str.replace(str.charAt(i), str.charAt(str.length() - 1 - i));
            System.out.println(str);
        }
        return str.equals(String.valueOf(x));
    }

    public static void main(String[] args) {
        Palindrome_Number p = new Palindrome_Number();
        System.out.println(p.isPalindrome(1221));
    }
}
