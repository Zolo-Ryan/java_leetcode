public class Q2081SumOfKMirrorNumbers {
    int[] digits = new int[100];
    public long kMirror(int k, int n) {
        long left = 1L, right = 0L, combined = 0L, ans = 0L;
        int count = 0;
        while(count < n){
            right = left * 10;
            for(int op = 0; op < 2; op++){
                for(long i = left; i < right && count < n; i++){
                    combined = i;
                    long x = op == 0 ? i / 10: i;
                    while (x > 0){
                        combined = combined * 10 + x % 10;
                        x /= 10;
                    }
                    if(isPalindrome(combined,k)){
                        count++;
                        ans += combined;
                    }
                }
            }
            left = right;
        }
        return ans;
    }
    public boolean isPalindrome(long num, int k){
        int length = -1;
        while(num > 0){
            digits[++length] = (int)(num % k);
            num /= k;
        }
        for(int i = 0, j = length; i < j; ++i, --j){
            if(digits[i] != digits[j]) return false;
        }
        return true;
    }
}
