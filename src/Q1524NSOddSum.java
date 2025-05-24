// TLE
public class Q1524NSOddSum {
        public static int numOfSubarrays(int[] arr){
            int n = arr.length,count = 0;
            int[] prefixSum = new int[n];
            prefixSum[0] = arr[0];
            if(prefixSum[0] % 2 == 1) count++;
            for(int i = 1;i<n;i++){
                prefixSum[i] = prefixSum[i-1] + arr[i];
                if(prefixSum[i] % 2 == 1) count++;
            }
            for(int i = 0;i<n;i++)
                for(int j = i + 1;j<n;j++){
                    int sum = prefixSum[j] - prefixSum[i];
                    if(sum % 2 == 1) count++;
                }
            return count;
        }
        public static void main(String[] args){
            int[] nums = new int[]{1,2,3,4,5,6,7};
            int ans = numOfSubarrays(nums);
            System.out.println("++++++++++++"+"\n"+ans);
        }
}
