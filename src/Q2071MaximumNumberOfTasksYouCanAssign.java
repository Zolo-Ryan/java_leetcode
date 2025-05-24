import java.util.*;

public class Q2071MaximumNumberOfTasksYouCanAssign {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int left = 1, right = Math.min(tasks.length,workers.length),mid = 0, ans = 0;
        while(left <= right){
            mid = left + (right - left)/2;
            if(check(tasks,workers,pills,strength,mid)){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
    public boolean check(int[] tasks,int[] workers,int pills,int strength,int k){
        TreeMap<Integer,Integer> ws = new TreeMap<>();
        for(int i = workers.length - k;i<workers.length;i++)
            ws.put(workers[i],ws.getOrDefault(workers[i],0) + 1);
        Integer key = 0;
        for(int i = k - 1;i >=0;i--){
            key = ws.lastKey();
            if(key >= tasks[i]){
            }else{
                if(pills == 0) return false;
                key = ws.ceilingKey(tasks[i] - strength);
                if(key == null) return false;
                pills--;
            }
            ws.put(key,ws.get(key) - 1);
            if(ws.get(key) == 0) ws.remove(key);
        }
        return true;
    }
    public boolean check_dequeue(int[] tasks,int[] workers,int pills,int strength,int k){
        int ptr = workers.length - 1;
        Deque<Integer> ws = new ArrayDeque<>();
        for(int i = k - 1; i >= 0;i--){
            while(ptr >= workers.length - k && workers[ptr] + strength >= tasks[i]) {
                ws.addFirst(workers[ptr]);
                ptr--;
            }
            if(ws.isEmpty()) return false;
            else if(ws.getLast() >= tasks[i]){
                ws.pollLast();
            }else{
                if(pills == 0) return false;
                ws.pollFirst();
                pills--;
            }
        }
        return true;
    }
}
