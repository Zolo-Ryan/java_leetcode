import java.util.Arrays;

public class Q2616MinimizeTheMaximumDiffereceOfPairs {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];
        while(left < right){
            int mid = left + (right - left) / 2;
            if(isItPossible(nums,mid) >= p){
                right = mid;
            }else left = mid + 1;
        }
        return left;
    }
    public int isItPossible(int[] nums,int k){
        int i = 0;
        int count = 0;
        while(i < nums.length - 1){
            if(nums[i + 1] - nums[i] <= k){
                count++;
                i++;
            }
            i++;
        }
        return count;
    }
}
