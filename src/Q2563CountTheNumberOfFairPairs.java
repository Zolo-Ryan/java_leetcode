import java.util.Arrays;

public class Q2563CountTheNumberOfFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for(int i = 0;i < nums.length;i++){
            long low = lower_bound(nums,i+1, nums.length - 1,lower - nums[i]);
            long high = lower_bound(nums,i+1, nums.length - 1,upper - nums[i]  + 1);
            ans += 1L * (high - low);
        }
        return ans;
    }
    public long lower_bound(int[] nums,int low,int high,int element){
        int mid;
        while(low <= high){
            mid = low + (high - low)/2;
            if(nums[mid] >= element) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
