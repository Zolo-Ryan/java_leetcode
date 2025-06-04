// TODO: OTHER WAY OF SOLUTION REMAINING
public class Q3403FIndLexicoLargestStringFromTheBoxI {
    public String answerString(String word, int numFriends) {
        String ans = "";
        if(numFriends == 1) return word;
        int n = word.length();
        for(int i = 0; i < n;i++){
            String sub = word.substring(i,Math.min(n - numFriends + 1, n - i) + i);
            if(sub.compareTo(ans) > 0)
                ans = sub;
        }
        return ans;
    }
}
