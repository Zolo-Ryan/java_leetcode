// INCORRECT
public class Q29DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        boolean isPositive = (dividend < 0 == divisor < 0);
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int ans = 0;
        while(a >= b){
            int q = 0;
            while(a > (b<<(q+1))) q++;
            ans += (1<<q);
            a -= b<<q;
        }
        if(ans == (1<<31) && isPositive) return Integer.MAX_VALUE;
        return isPositive ? ans : -ans;
    }
}
