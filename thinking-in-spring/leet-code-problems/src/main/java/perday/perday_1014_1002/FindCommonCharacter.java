package perday.perday_1014_1002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacter {
    public List<String> commonChars(String[] A){
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String str : A) {
            int[] chars = new int[26];
            for (int i = 0; i < str.length(); i++) {
                chars[str.charAt(i)-'a']++;
            }

            for (int i = 0; i < minFreq.length; i++) {
                minFreq[i] = Math.min(minFreq[i], chars[i]);
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < minFreq.length; i++) {
            res.
        }
    }
}
