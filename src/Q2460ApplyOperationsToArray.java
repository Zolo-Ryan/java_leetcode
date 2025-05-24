public class Q2460ApplyOperationsToArray {
    public int[] applyOperations(int[] nums){
        int n = nums.length;
        for(int i = 0;i<n-1;i++){
            if(nums[i] == nums[i+1]){
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }
        int zeros = 0;
        for(int i = 0;i<n;i++)
            if(nums[i] == 0) zeros++;
        int[] ans = new int[n];
        int k = 0;
        for(int i = 0;i<n;i++)
            if(nums[i] != 0) ans[k++] = nums[i];
        return ans;
    }
}
