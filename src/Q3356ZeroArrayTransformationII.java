import java.util.HashSet;

public class Q3356ZeroArrayTransformationII {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, left = 0, right = queries.length;
        if(!canFormZeroArray(nums,queries,right)) return -1;

        while(left <= right){
            int middle = left + (right - left) / 2;
            if(canFormZeroArray(nums,queries,middle))
                right = middle - 1;
            else left = middle + 1;
        }
        return left;
    }
    public boolean canFormZeroArray(int[] nums,int [][] queries,int k){
        int len = nums.length;
        int[] diff = new int[len + 1];
        for(int i = 0;i<k;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            int val = queries[i][2];
            diff[start] += val;
            diff[end + 1] -= val;
        }
        int sum = 0;
        for(int i = 0;i<len;i++){
            sum += diff[i];
            diff[i] = sum;
        }
        for(int i = 0;i<len;i++)
            if(nums[i] > diff[i]) return false;
        return true;
    }

    public int minZeroArray_fast(int[] nums,int[][] queries){
        int n = nums.length, sum = 0, k = 0;
        int[] diff = new int[n + 1];
        for(int i = 0;i<n;i++){
            while(sum + diff[i] < nums[i]){
                k++;
                if(k > queries.length) return -1;
                int left = queries[k-1][0], right = queries[k-1][1], val = queries[k-1][2];
                if(right >= i){
                    diff[Math.max(left,i)] += val;
                    diff[right + 1] -= val;
                }
            }
            sum += diff[i];
        }
        return k;
    }
}
