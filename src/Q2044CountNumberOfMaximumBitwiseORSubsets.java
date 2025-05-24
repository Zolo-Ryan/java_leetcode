public class Q2044CountNumberOfMaximumBitwiseORSubsets {
    public int countMaxOrSubsets(int[] nums) {
        int target = 0;
        for(int i = 0;i<nums.length;i++) target |= nums[i];
        return solve(nums,0,nums.length,0,target);
    }
    public int solve(int[] arr,int i,int n,int currentSum,int targetSum){
        if(i>=n){
            if(currentSum == targetSum) return 1;
            else return 0;
        }
        int take = solve(arr,i+1,n,arr[i] | currentSum,targetSum);
        int leave = solve(arr,i+1,n,currentSum,targetSum);
        return take + leave;
    }
    public int countMaxOrSubsets_2(int[] nums){
        int target = 0;
        for(int i:nums) target |= i;
        Integer[][] memo = new Integer[nums.length][target+1];
        return solve(nums,0,0,target,memo);
    }
    public int solve(int[] arr,int i,int current,int target,Integer[][] memo){
        if(i == arr.length){
            return current == target ? 1 : 0;
        }
        if(memo[i][current] != null) return memo[i][current];
        int take = solve(arr,i+1,current | arr[i],target,memo);
        int leave = solve(arr,i+1,current,target,memo);
        return memo[i][current] = take + leave;
    }
}
