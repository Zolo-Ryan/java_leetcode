public class Q2401LongestNiceSubarray {
    public int longestNiceSubarray(int[] nums) {
        int orSum = nums[0];
        int count = 1;
        int maxCount = 1;
        int left = 0;
        int right = 1;
        while(right < nums.length){
            if((nums[right] & orSum) == 0){
                count++;
                maxCount = Math.max(count,maxCount);
                orSum |= nums[right];
                right++;
            }else{
                count--;
                orSum ^= nums[left];
                left++;
            }
        }
        return maxCount;
    }
}
