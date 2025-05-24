public class Q2962CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    public long countSubarrays(int[] nums, int k) {
        int max = nums[0];
        int count = 0, len = nums.length;
        long ans = 0;
        for(int i = 1;i<nums.length;i++) max = Math.max(max,nums[i]);
        for(int l = 0, r = 0;r < nums.length;r++){
            if(nums[r] == max) count++;
            if(count >= k){
                ans += len - r;
                while(l < r && count>=k){
                    if(nums[l] == max) count--;
                    if(count >= k) ans += len - r;
                    l++;
                }
            }
        }
        return ans;
    }
}
