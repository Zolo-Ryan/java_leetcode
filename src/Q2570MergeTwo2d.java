import java.util.HashMap;

public class Q2570MergeTwo2d {
    public int[][] mergeArrays(int[][] nums1,int[][] nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] ans = getAns(nums1, nums2, n1, n2);
        int i = 0, j = 0;
        int k = 0;
        while(i < n1 && j < n2){
            if(nums1[i][0] < nums2[j][0]){
                ans[k][0] = nums1[i][0];
                ans[k][1] = nums1[i][1];
                i++;
            }else if(nums1[i][0] > nums2[j][0]){
                ans[k][0] = nums2[j][0];
                ans[k][1] = nums2[j][1];
                j++;
            }else{
                ans[k][0] = nums2[j][0];
                ans[k++][1] = nums2[j++][1] + nums1[i++][1];
            }
        }
        while(i < n1){
            ans[k++] = nums1[i++];
        }
        while(j < n2){
            ans[k++] = nums2[j++];
        }
        return ans;
    }

    private static int[][] getAns(int[][] nums1, int[][] nums2, int n1, int n2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< n1; i++) {
            if(map.get(nums1[i][0]) == null)
                map.put(nums1[i][0], 1);
            else map.put(nums1[i][0],map.get(nums1[i][0]) + 1);
        }
        for(int i = 0; i< n2; i++) {
            if(map.get(nums2[i][0]) == null)
                map.put(nums2[i][0], 1);
            else map.put(nums2[i][0],map.get(nums2[i][0]) + 1);
        }
        int n = map.size();
        int[][] ans = new int[n][2];
        return ans;
    }
}
