public class Q1863SumOfAllSubsetXORTotals {
    public int subsetXORSum(int[] nums){
        return solve(nums,0,0,nums.length);
    }
    public int solve(int[] arr,int i,int current,int n){
        if(i >= n){
            return current;
        }
        int take = solve(arr,i+1,current ^ arr[i],n);
        int leave = solve(arr,i+1,current,n);
        return take + leave;
    }
}
