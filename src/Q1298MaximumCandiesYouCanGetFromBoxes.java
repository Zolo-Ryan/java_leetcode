import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Q1298MaximumCandiesYouCanGetFromBoxes {
    public static int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        if(initialBoxes.length == 0) return 0;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> keySet = new HashSet<>();
        for(int box: initialBoxes) {
            q.offer(box);
            if(status[box] == 1){
                status[box] = 0;
                keySet.add(box);
            }
        }
        int ans = 0;
        do {
            int box = q.poll();
            System.out.println("Box: "+box);
            ans += solve(box,keySet,containedBoxes,q,candies,status,keys);
            if(status[box] == 0){
                q.offer(box);
            }
        }while(!keySet.isEmpty() && !q.isEmpty());
        return ans;
    }
    public static int solve(int box,HashSet<Integer> keySet,int[][] containedBoxes,Queue<Integer> q,int[] candies,int[] status,int[][] keys){
        if(status[box] == 0){
            if(keySet.contains(box)){
                status[box] = 1;
                keySet.remove(box);
            }
        }
        int tempCandies = 0;
        if(status[box] == 1){
            // adding keys
            for(int key: keys[box]){
                if(status[key] == 0)
                    keySet.add(key);
            }
            // appending boxes
            for(int boxX: containedBoxes[box]){
                q.offer(boxX);
                if(status[boxX] == 1){
                    status[boxX] = 0;
                    keySet.add(boxX);
                }
            }
            tempCandies = candies[box];
            candies[box] = 0;
        }
        return tempCandies;
    }

    public static void main(String[] args) {
        int[] status = new int[]{1,1,1};
        int[] candies = {2,3,2};
        int[][] keys = {{},{},{}};
        int[][] containedBoxes = {{},{},{}};
        int[] initBoxes = {2,1,0};
        System.out.println(maxCandies(status,candies,keys,containedBoxes,initBoxes));
    }
}
