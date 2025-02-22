//3110. Score of a String

import java.util.Arrays;

public class Score_of_a_String
{
    public int scoreOfString(String s) {
        s = s.toLowerCase();
        int[] score = new int[s.length()];
        for (int i = 0; i < s.length() - 1; i++) {
            score[i] = Math.abs(s.charAt(i) - s.charAt(i+1));
        }
        return Arrays.stream(score).sum();
    }
}
