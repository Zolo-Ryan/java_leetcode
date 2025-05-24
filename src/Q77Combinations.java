import java.util.ArrayList;
import java.util.List;

public class Q77Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        backtrack(1,comb,ans,n,k);
        return ans;
    }
    public static void backtrack(int start, List<Integer> comb,List<List<Integer>> ans,int n,int k){
        if(comb.size() == k){
            ans.add(new ArrayList<>(comb));
            return;
        }
        for(int i = start;i<=n;i++){
            comb.add(i);
            backtrack(i+1,comb,ans,n,k);
            comb.remove(comb.size() - 1);
        }
    }
    public static void main(String[] args){
        int n = 4,k = 2;
        List<List<Integer>> ans = combine(n,k);
        System.out.println(ans);
    }
}
