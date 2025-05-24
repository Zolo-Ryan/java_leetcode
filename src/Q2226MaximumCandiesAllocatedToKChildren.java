public class Q2226MaximumCandiesAllocatedToKChildren {
    public static int maximumCandies(int[] candies, long k) {
        long sum = 0;
        int max = candies[0];
        for(int i = 0;i<candies.length;i++) {
            sum += candies[i];
            max = Math.max(max,candies[i]);
        }
        if(sum < k) return 0;
        int left = 1, right = max,mid = 0;
        while(left <= right){
            mid = left + (right - left)/2;
//            System.out.println(mid);
            if(checkCandiesDistributed(candies,k,mid))
                left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }
    public static boolean checkCandiesDistributed(int[] candies,long k,int c){
        long count = 0;
        for(int i = 0;i<candies.length;i++){
            count += candies[i]/c;
            if(count >= k) return true;
        }
        return false;
    }
    public static void main(String[] args){
        int[] candies = new int[]{5,8,6};
        int k = 3;
        System.out.println(maximumCandies(candies,k));
    }
}
