// INCORRECT
public class Q790DominoAndTrominoTiling {
    private int MOD = 1_000_007;
    public int numTilings(int n) {
        int[][] dp = new int[n+1][4];
        for(int i = 0; i < n + 1;i++)
            for(int j = 0;j < 4;j++)
                dp[i][j] = -1;
        // 4 states, 11, 01, 10, 00
        return solve(0,n,dp,true,true);
    }
    public int solve(int i,int n,int[][] dp,boolean t1,boolean t2){
        if(i == n) return 1;
        int state = makeState(t1,t2);
        if(dp[i][state] != -1) return dp[i][state];
        boolean t3 = i + 1 < n;
        boolean t4 = i + 1 < n;
        long count = 0;
        if(t1 && t2 && t3) count += solve(i+1,n,dp,false,true);
        if(t1 && t2 && t4) count += solve(i+1,n,dp,true,false);
        if(t1 && !t2 && t3 && t4) count += solve(i+1,n,dp,false,false);
        if(!t1 && t2 && t3 && t4) count += solve(i+1,n,dp,false,false);
        if(t1 && t2) count += solve(i+1,n,dp,true,true);
        if(t1 && t2 && t3 && t4) count += solve(i+1,n,dp,false,false);
        if(t1 && !t2 && t3) count += solve(i+1,n,dp,false,true);
        if(!t1 && t2 && t4) count += solve(i+1,n,dp,true,false);
        if(!t1 && !t2) count += solve(i+1,n,dp,true,true);
        return dp[i][state] = (int)(count % MOD);
    }
    public int makeState(boolean t1,boolean t2){
        int state = 0;
        if(t1) state |= 1;
        if(t2) state |= 2;
        return state;
    }
}
