public class Q3191MinOperationsToMakeBinaryArrayElementsEqualToOneI {
    public int minOperations(int[] nums){
        int count = 0;
        int n = nums.length;
        for(int i = 0;i <= n - 3;i++){
            if(nums[i] == 1) continue;
            else{
                nums[i] ^= 1;
                nums[i+1] ^= 1;
                nums[i+2] ^= 1;
                count++;
            }
        }
        if(nums[n-1] == nums[n-2] && nums[n-3] == nums[n-2] && nums[n-3] == 1) return count;
        return -1;
    }
}
