package hot100.hot_003;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s){
        int length = 0;
        int j=0;

        Set<Character> set = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            if (i !=0 ){
                set.remove(s.charAt(i-1));
            }

            while (j<s.length() && set.add(s.charAt(j))){
                j++;
            }
            length = Math.max(length, set.size());
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    private double getKth(int[] nums1, int[] nums2, int k){
        if (nums1.length == 0){
            return nums2[k-1];
        }

        int s1=0, s2=0;
        while (k > 1){
            int index = Math.min(k/2, nums1.length);
            int i = (s1 + index - 1) < nums1.length ? nums1[s1 + index - 1] : Integer.MAX_VALUE;
            int j = (s2 + index - 1) < nums2.length ? nums2[s2 + index - 1] : Integer.MAX_VALUE;
            if (i >= j){
                s2 = s2+index;
            } else {
                s1 = s1+index;
            }
            k=k-index;
        }
        return Math.min(s1<nums1.length?nums1[s1]:Integer.MAX_VALUE,
                s2<nums2.length?nums2[s2]:Integer.MAX_VALUE);
    }
}