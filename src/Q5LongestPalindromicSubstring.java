public class Q5LongestPalindromicSubstring {
    public static String longestPalindrome(String s){
        int n = s.length();
        char[] string = s.toCharArray();
        int iIndex = 0;
        int jIndex = 0;
        int maxLen = 0;
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                if(checkPalindrome(string,i,j)){
                    int len = j - i + 1;
                    if(maxLen < len){
                        maxLen = len;
                        iIndex = i;
                        jIndex = j;
                    }
                }
            }
        }
        String ans = String.copyValueOf(string,iIndex,jIndex - iIndex + 1);
        return ans;
    }
    public static boolean checkPalindrome(char[] arr,int start,int end){
        for(int i = start;i<=end/2;i++){
            if(arr[i] != arr[end]) return false;
        }
        return true;
    }
    public static void main(String[] args){
        String string = "aba";
        System.out.println(longestPalindrome(string));
    }
}
