import java.util.ArrayList;
import java.util.List;

public class Q3211GenerateBinaryStringsWithoutAdjacentZeros {
    public List<String> validStrings(int n){
        List<String> ans = new ArrayList<>();
        if(n == 1){
            ans.add("0");
            ans.add("1");
            return ans;
        }
        String str = "";
        solve(n,str,ans);
        return ans;
    }
    public void solve(int n,String str,List<String> ans){
        if(n == 0){
            ans.add(str);
            return;
        }
        if(str.isEmpty() || str.charAt(str.length() - 1) == '1'){
            solve(n-1,str+"0",ans);
            solve(n-1,str+"1",ans);
        }else{
            solve(n-1,str+"1",ans);
        }
    }
}
