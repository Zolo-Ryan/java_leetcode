import java.util.*;

public class Q401BinaryWatch {
    public static List<String> readBinaryWatch(int turnedOn) {
        if(turnedOn > 8)
            return new ArrayList<>();
        int minutes = 0, hours = 0; // minutes = 111_111, hours 1_111, minutes <= 59, hours <= 11
        List<String> ans = new ArrayList<>();
        solve(turnedOn,minutes,hours,ans);
        HashSet<String> set = new HashSet<>(ans);
        ans.clear();
        for(String str: set)
            ans.add(str);
        return ans;
    }
    public static void solve(int turnedOn,int minutes, int hours, List<String> ans){
        if(minutes >= 60 || hours >= 12 || turnedOn < 0 || minutes < 0 || hours < 0) return;
        if(turnedOn == 0){
            ans.add(hours+":"+minuteToString(minutes));
            return;
        }
        for(int i = 1;i<=6;i++){
            solve(turnedOn-1,setBit(minutes,i),hours,ans);
        }
        for(int i = 1;i<=4;i++){
            solve(turnedOn - 1,minutes,setBit(hours,i),ans);
        }
    }
    private static int setBit(int n,int loc){
        int val =  (int)(n|(1<<(loc-1)));
        return val == n ? -1 : val;
    }
    private static String minuteToString(int minute){
        if(minute < 10) return "0"+minute;
        return minute+"";
    }
/* Now we will see the n*m solution (12*60). above is backtracking soln, other way is to iterate over
 * all the hours and minutes, convert them to bitset, if the count of set bits == turnedOn then we got our ans
 * */
    public List<String> readBinaryWatch_fast(int turnedOn){
        List<String> ans = new ArrayList<>();
        for(int h = 0;h < 12;h++)
            for(int m = 0;m < 60;m++){
                if(Integer.bitCount(h) + Integer.bitCount(m) == turnedOn)
                    ans.add(h+(m<10? ":0": ":")+m);
            }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(readBinaryWatch(2));
    }
}
