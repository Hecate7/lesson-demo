package hot100.hot_005;

public class LongestPalindrome {
    public static String longestPalindrome(String s){
        String subPalindrome = String.valueOf(s.charAt(0));
//        String subPalindrome = "";
        for (int mid = 0; mid < 2*s.length()-1; mid++) {
            //mid为偶数时，回文子串为奇数位
            //mid为奇数时，回文子串为偶数位
            int i=0, j=0;
            if (mid%2==0){
                i=mid/2-1;
                j=mid/2+1;
            } else {
                i=(mid+1)/2-1;
                j=(mid+1)/2;
            }

            while (i>=0 && j<=s.length()-1 && s.charAt(i)==s.charAt(j)){
                i--;
                j++;
            }

            subPalindrome = ((j-1)-(i+1)+1)>subPalindrome.length()?s.substring(i+1,j):subPalindrome;
        }
        return subPalindrome;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
