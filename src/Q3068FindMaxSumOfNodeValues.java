import java.util.*;

public class Q3068FindMaxSumOfNodeValues {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long[][] memo = new long[nums.length][2];
        for(long[] row: memo)
            Arrays.fill(row,-1);
        return maxSumOfNodes(0,k,nums,1,memo);
    }
    public long maxSumOfNodes(int i,int k,int[] nums,int isEven,long[][] memo){
        if(i == nums.length)
            return isEven == 1 ? 0 : Integer.MIN_VALUE;
        if(memo[i][isEven] != -1) return memo[i][isEven];

        long xor = (nums[i] ^ k) + maxSumOfNodes(i+1,k,nums,isEven^1,memo);
        long nxor = nums[i] + maxSumOfNodes(i+1,k,nums,isEven,memo);
        return memo[i][isEven] = Math.max(xor,nxor);
    }
}
