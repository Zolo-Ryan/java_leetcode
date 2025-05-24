public class Q38CountAndSay {
    public String countAndSay(int n) {
        StringBuilder ans = new StringBuilder();
        ans.append("1");
        for(int i = 2;i <= n;i++){
            ans = convertToRunLengthEncoding(ans.toString());
        }
        return ans.toString();
//        return countAndSayRecurse(n);
    }
    private StringBuilder convertToRunLengthEncoding(String prev){
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while(i < prev.length()){
            int count = 1;
            char current = prev.charAt(i);
            int j = i + 1;
            for(;j<prev.length() && prev.charAt(j) == current ;j++) count++;
            i = j;
            builder.append(count);
            builder.append(current);
        }
        return builder;
    }
}
