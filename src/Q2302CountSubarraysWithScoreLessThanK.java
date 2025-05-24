public class Q2302CountSubarraysWithScoreLessThanK {
    public static long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long res = 0, total = 0;
        for (int i = 0, j = 0; j < n; j++) {
            total += nums[j];
            while (i <= j && total * (j - i + 1) >= k) {
                total -= nums[i];
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums = new int[]{2,1,4,3,5};
        int k = 10;
        countSubarrays(nums,k);
    }
}
