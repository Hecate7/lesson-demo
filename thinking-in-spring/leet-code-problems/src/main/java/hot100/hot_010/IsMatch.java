package hot100.hot_010;

public class IsMatch {
    public boolean isMatch(String s, String p){
        s=" ".concat(s);
        p=" ".concat(p);
        boolean [][]dp = new boolean[s.length()][p.length()];
        dp[0][0] = true;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < p.length(); j++) {
                if (matches(s, p, i, j)){
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j)=='*'){
                    if (matches(s, p, i, j-1)){
                        dp[i][j]=dp[i][j-2]||dp[i][j-1]||dp[i-1][j];
                    } else {
                        dp[i][j]=dp[i][j-2];
                    }
                }
            }
        }
        return dp[s.length()-1][p.length()-1];
    }

    private boolean matches(String s, String p, int i, int j){
        if (i==0) return false;
        return s.charAt(i)==p.charAt(j) || p.charAt(j)=='.';
    }

    public static boolean isMatch1(String s, String p){
        int i=0, j=0;
        while (i<s.length() && j<p.length()){
            char symbol = s.charAt(i);
            char pattern = p.charAt(j);
            if (symbol == pattern || pattern == '.'){
                i++;
                j++;
            } else {
                if (pattern == '*'){
                    char prv = p.charAt(j - 1);
                    if (symbol == prv || prv == '.'){
                        i++;
                    } else {
                        while (j+1<p.length() && '*'==p.charAt(j+1)){
                            j++;
                        }

                        if (j+1<p.length() && symbol == p.charAt(j+1)){
                            i++;
                            j=j+2;
                        } else {
                            return false;
                        }
                    }
                } else {
                    if (j+1<p.length() && '*'==p.charAt(j+1)){
                        j++;
                    } else {
                        return false;
                    }
                }
            }
        }

        if (i<s.length() || (j<p.length() && !(j==p.length()-1 && p.charAt(j)=='*'))){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsMatch isMatch = new IsMatch();
        System.out.println(isMatch.isMatch("aa", "a*"));
//        System.out.println(isMatch1("aaaaaaaaaaaaaaab", "a*******b"));
    }
}
