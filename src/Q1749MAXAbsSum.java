public class Q1749MAXAbsSum {
    public static int maxAbsoluteSum_dp(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][n];
        int max = 0;
        dp[0][0] = nums[0];
        max = Math.max(max,Math.abs(nums[0]));
        for(int i = 1;i<n;i++){
            dp[0][i] = dp[0][i-1] + nums[i];
            max = Math.max(max,Math.abs(dp[0][i]));
            max = Math.max(max,Math.abs(nums[i]));
            dp[i][i] = nums[i];
        }

        for(int i = 1;i<n;i++){
            for(int j = i+1;j<n;j++) {
                dp[i][j] = dp[i - 1][j] - dp[i - 1][i - 1];
                max = Math.max(max,Math.abs(dp[i][j]));
            }
        }
        printArray(dp);
        return max;
    }
    public static int maxAbsoluteSum(int[] nums){
        int sum = nums[0];
        int maxSum = Math.max(nums[0], 0);
        int minSum = Math.min(nums[0], 0);
        for(int i = 1;i<nums.length;i++){
            sum += nums[i];
            if(sum < minSum) minSum = sum;
            if(sum > maxSum) maxSum = sum;
        }
        return Math.abs(maxSum - minSum);
    }
    public static int maxAbsoluteSum_kadane(int[] nums){
        int sum = kadaneAlgo(nums,true);
        int nSum = kadaneAlgo(nums,false);
        return Math.max(sum,Math.abs(nSum));
    }
    public static int kadaneAlgo(int[] arr,boolean flag){
        int res = arr[0];
        int ending = arr[0];
        for(int i = 1;i<arr.length;i++){
            if(flag){
                ending = Math.max(ending+arr[i],arr[i]);
                res = Math.max(res,ending);
            }else{
                ending = Math.min(ending+arr[i],arr[i]);
                res = Math.min(res,ending);
            }
        }
        return res;
    }
    public static void printArray(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++)
                System.out.printf("%3d ",arr[i][j]);
            System.out.println();
        }
    }
    public static void main(String[] args){
        int[] arr = new int[]{-3,-5,-3,-2,-6,3,10,-10,-8,-3,0,10,3,-5,8,7,-9,-9,5,-8};
        int ans = maxAbsoluteSum(arr);
        System.out.println("=================");
        System.out.println(ans);
    }
}
