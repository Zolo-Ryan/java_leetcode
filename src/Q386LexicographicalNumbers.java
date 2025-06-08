import java.util.ArrayList;
import java.util.List;

public class Q386LexicographicalNumbers {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1;i<10;i++)
            dfs(i,ans,n);
        return ans;
    }
    public static void dfs(int currentNumber,List<Integer> ans,int n){
        if(currentNumber > n){
            return;
        }
        ans.add(currentNumber);
        for(int i = 0; i < 10;i++){
            int nextNumber = currentNumber * 10 + i;
            if(nextNumber > n) return;
            dfs(nextNumber,ans,n);
        }
    }
    public static void main(String[] args) {
        List<Integer> ans = lexicalOrder(13);
        System.out.println(ans);
    }
}
