public class Q2529MAXCOUNTOfPositiveIntegerAndNegativeInteger {
    public int maximumCount(int[] nums) {
        int neg = 0;
        int pos = 0;
        for(int i = 0;i<nums.length;i++)
            if(nums[i] < 0) neg++;
            else if(nums[i] > 0) pos++;
        return Math.max(neg,pos);
    }
    public int maximumCount_logn(int[] nums){
        int posCount = nums.length - upperBound(nums,0);
        int negCount = nums.length - lowerBound(nums,0);
        return Math.max(posCount,negCount);
    }
    public int lowerBound(int[] arr,int find){
        int start = 0,end = arr.length - 1;
        int index = arr.length;
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] < find) start = mid + 1;
            else if (arr[mid] >= find) {
                end = mid - 1;
                index = mid;
            }
        }
        return index;
    }
    public int upperBound(int[] arr,int find){
        int start = 0, end = arr.length - 1;
        int index = arr.length;
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] <= find) start = mid+1;
            else if(arr[mid] > find){
                end = mid - 1;
                index = mid;
            }
        }
        return index;
    }
}
