import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_Words_Containing_Character {

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            boolean found = false;
            for (int j = 0; j < words[i].length(); j++) {
                if (words[i].charAt(j) == x) {
                    found = true;
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Find_Words_Containing_Character obj = new Find_Words_Containing_Character();
        System.out.println(obj.findWordsContaining(new String[] {"leet","code"}, 'e'));
    }
}
