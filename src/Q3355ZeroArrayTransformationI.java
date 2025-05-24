public class Q3355ZeroArrayTransformationI {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] diff = new int[nums.length + 1];
        for(int i = 0;i< queries.length;i++){
            int left = queries[i][0];
            int right = queries[i][1];
            diff[left] += 1;
            diff[right + 1] -= 1;
        }
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            sum += diff[i];
            if(sum < nums[i]) return false;
        }
        return true;
    }
}
