import java.util.ArrayList;

public class Q2444CountSubArraysWithFixedBounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int maxi = -1,mini = -1,ans = 0;
        for(int l = 0, r = 0; r < nums.length;r++){
            int ele = nums[r];
            if(ele < minK || ele>maxK){
                l = r + 1;
                continue;
            }
            if(ele == maxK) maxi = r;
            if(ele == minK) mini = r;
            ans += Math.max(Math.min(maxi,mini) - l + 1, 0);
        }
        return ans;
    }
}
