// INCORRECT
public class Q3362ZeroArrayTransformationIII {
    public int maxRemoval(int[] nums, int[][] queries) {
        int len = nums.length, sum = 0, k = 0;
        int[] diff = new int[len + 1];
        int skip = 0;
        for(int i = 0;i<len;i++){
            while(sum + diff[i] < nums[i]){
                k++;
                if(k > queries.length) return -1;
                int left = queries[k-1][0];
                int right = queries[k-1][1];
                if(right >= i){
                    diff[Math.max(left,i)]++;
                    diff[right + 1]--;
                }
                if(left < i) skip++;
            }
            sum += diff[i];
        }
        return skip + queries.length - k;
    }
}
