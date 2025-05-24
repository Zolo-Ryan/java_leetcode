import java.util.HashMap;

public class Q2537CountNumberOfGoodSubarrays {
    public static long countGood(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        long res = 0;
        long count = 0;
        int j = 0;
        int len = nums.length;
        for(int i = 0; i < len;i++){
            int element = nums[i];
            if(map.containsKey(element)){
                count += map.get(element);
                map.put(element,map.get(element) + 1);
            }else{
                map.put(element,1);
            }
            if(count >= k){
                res += len - i;
            }
            while(count >= k){
                int jElement = nums[j];
                if(map.get(jElement) > 1){
                    map.put(jElement,map.get(jElement) - 1);
                    count -= map.get(jElement);
                }else{
                    map.remove(jElement);
                }
                if(count >= k) res += len - i;
                j++;
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums = new int[]{2,1,3,1,2,2,3,3,2,2,1,1,1,3,1};
        int k = 11;
        System.out.println(countGood(nums,k));
    }
}
