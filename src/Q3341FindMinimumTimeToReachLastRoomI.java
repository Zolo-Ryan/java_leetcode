import java.util.Arrays;

public class Q3341FindMinimumTimeToReachLastRoomI {
    public static int minTimeToReach(int[][] moveTime) {
        boolean[][] traversed = new boolean[moveTime.length][moveTime[0].length];
        int[][] dp = new int[moveTime.length][moveTime[0].length];
        for (int[] ints : dp) Arrays.fill(ints, Integer.MAX_VALUE);
        return solve(0,0,0,moveTime,traversed,dp);
    }
    public static int solve(int i,int j,int currTime,int[][] arr,boolean[][] traversed,int[][] dp){
        if(i >= arr.length || i < 0 || j >= arr[i].length || j < 0 || traversed[i][j]) return Integer.MAX_VALUE;
        traversed[i][j] = true;
        if(i == arr.length - 1 && j == arr[i].length - 1) {
            traversed[i][j] = false;
            return currTime;
        }
        if(dp[i][j] <= currTime){
            traversed[i][j] = false;
            return dp[i][j];
        }
        int left = solve(i,j-1,returnTime(currTime,i,j - 1,arr),arr,traversed,dp);
        int right = solve(i,j+1,returnTime(currTime,i,j + 1,arr),arr,traversed,dp);
        int up = solve(i - 1,j,returnTime(currTime,i - 1,j,arr),arr,traversed,dp);
        int down = solve(i + 1,j,returnTime(currTime,i + 1,j,arr),arr,traversed,dp);
        traversed[i][j] = false;
        return dp[i][j] = Math.min(Math.min(left,right),Math.min(up,down));

    }
    public static int returnTime(int currTime,int i,int j,int[][] arr){
        if(i >= arr.length || i < 0 || j >= arr[i].length || j < 0) return Integer.MAX_VALUE;
        if(currTime >= arr[i][j]) return currTime + 1;
        else return arr[i][j] + 1;
    }
    public static void main(String[] args){
        int[][] moveTime = new int[][]{{27, 85}, {22, 53}};
        System.out.println(minTimeToReach(moveTime));
    }
}
