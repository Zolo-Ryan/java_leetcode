import java.util.*;

public class Q1415TheKthLexicoStringAllHappyStringsOfLengthN {
    public String getHappyString(int n,int k){
        List<String> res = new ArrayList<>();
        String str = "";
        solve(n,str,res);
        Collections.sort(res);
        return k > res.size() ? "" : res.get(k-1);
    }
    public void solve(int n,String str,List<String> res){
        if(n == 0){
            res.add(str);
            return;
        }
        if(str.isEmpty()){
            solve(n-1,"a",res);
            solve(n-1,"b",res);
            solve(n-1,"c",res);
            return;
        }
        if(str.charAt(str.length() - 1) == 'a'){
            solve(n-1,str+"b",res);
            solve(n-1,str+"c",res);
        }else if(str.charAt(str.length() - 1) == 'b'){
            solve(n-1,str+"a",res);
            solve(n-1,str+"c",res);
        }else{
            solve(n-1,str+"b",res);
            solve(n-1,str+"a",res);
        }
    }
    public String getHappyString_combinatorics(int n,int k){
        int total = 3 * (1<<n-1);
        if(k > total) return "";
        StringBuilder res = new StringBuilder(n);
        for(int i = 0;i<n;i++)
            res.append('a');
        Map<Character,Character> nextSmallest = new HashMap<>();
        nextSmallest.put('a','b');
        nextSmallest.put('b','a');
        nextSmallest.put('c','a');
        Map<Character,Character> nextGreatest = new HashMap<>();
        nextGreatest.put('a','c');
        nextGreatest.put('b','c');
        nextGreatest.put('c','b');

        int startA = 1;
        int startB = startA + (1<<(n-1));
        int startC = startB + (1<<(n-1));
        if(k < startB){
            res.setCharAt(0,'a');
            k -= startA;
        }else if(k < startC){
            res.setCharAt(0,'b');
            k -= startB;
        }else{
            res.setCharAt(0,'c');
            k -= startC;
        }
        for(int i = 1;i<n;i++){
            int midpoint = (1 << (n-i-1));
            if(k < midpoint){
                res.setCharAt(i,nextSmallest.get(res.charAt(i-1)));
            }else{
                res.setCharAt(i,nextGreatest.get(res.charAt(i-1)));
                k -= midpoint;
            }
        }
        return res.toString();
    }
}
