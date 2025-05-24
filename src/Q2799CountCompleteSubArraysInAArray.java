import java.util.HashMap;
import java.util.HashSet;

public class Q2799CountCompleteSubArraysInAArray {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> distinct = new HashSet<>();
        for(int i = 0;i<nums.length;i++)
            distinct.add(nums[i]);
        int distinctElements = distinct.size();
        int left = 0, right = 1; // right is exclusive
        int count = 0;
        HashMap<Integer,Integer> elementCount = new HashMap<>();
        elementCount.put(nums[0],1);

        while(right < nums.length) {
            for (; right < nums.length; right++) {
                if (elementCount.size() == distinctElements) break;
                elementCount.putIfAbsent(nums[right], 0);
                elementCount.computeIfPresent(nums[right], (key, val) -> val + 1);
            }
            count += 1;
            while (left < right && distinctElements == elementCount.size()) {
                count += nums.length - right;
                elementCount.computeIfPresent(nums[left], (key, val) -> {
                    if(val - 1 == 0) return null;
                    else return val - 1;
                });
                left++;
            }
        }
        return count;
    }
    public static void main(String[] args){

    }
}
