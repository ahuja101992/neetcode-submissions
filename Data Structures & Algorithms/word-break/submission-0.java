class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true ;
        for (int i=1;i<=n;i++){
            for (int j=0;j<i;j++){
                // System.out.println(s.substring(j,i));
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i]= true ;
                }
            }
            // System.out.println(i + " " + dp[i]);
        }
        return dp[n];
    }
}