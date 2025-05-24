public class Q1780CheckIfSumOfPowersOfThree {
    public boolean checkPowersOfThree(int n){
        return check(n);
    }
    public boolean check(int n){
        if(n == 2) return false;
        int val = 0;
        while(n != 0){
            val = n % 3;
            if(val == 2) return false;
            n /= 3;
        }
        return true;
    }
}
