public class Length_of_Last_Word {

    public int lengthOfLastWord(String s) {

        int ultIndice = s.length() - 1, primIndice = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(ultIndice) == ' ') {
                ultIndice--;
            }
        }

        for (int i = ultIndice; i > 0; i--) {
            if (s.charAt(i) == ' ') {
                primIndice = i + 1;
                break;
            }
        }
        primIndice--;

        return ultIndice - primIndice;
    }

    public static void main(String[] args) {
        Length_of_Last_Word l = new Length_of_Last_Word();
        System.out.println(l.lengthOfLastWord("   fly me   to   the moon  "));
    }
}
