public class Solution {
  public boolean isInterleave(String s1, String s2, String s3) {
    if( s1.length() + s2.length() != s3.length() )
      return false;
    boolean dp[][] = new boolean[s1.length()+1][s2.length()+1];
    dp[0][0] = true;
    for( int i = 1; i <= s1.length(); ++i ) {
      dp[i][0] = s3.substring(0, i).equals(s1.substring(0, i));
    }
    for( int i = 1; i <= s2.length(); ++i ) {
      dp[0][i] = s3.substring(0, i).equals(s2.substring(0, i));
    }
    for( int i = 1; i <= s1.length(); ++i ) {
      for( int j = 1; j <= s2.length(); ++j ) {
        boolean b1 = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
        boolean b2 = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
        dp[i][j] = b1 || b2;
      }
    }
    return dp[s1.length()][s2.length()];
  }
}
