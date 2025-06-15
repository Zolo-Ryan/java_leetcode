public class Q1432MaxDifferenceYouCanGetFromChangingAnInteger {
    public static int maxDiff(int num){
        int digits = countDigits(num);
        int firstDigit = (num / (int)Math.pow(10,digits-1)) % 10;
        int maxAt = (num / (int)Math.pow(10,digits-1)) % 10;
        int minAt = firstDigit;
        for(int i = digits; i >= 1;i--){
            int digit = (num / (int)Math.pow(10,i-1)) % 10;
            if(digit != 9){
                maxAt = digit;
                break;
            }
        }
        if(minAt == 1){
            for(int i = digits; i >= 1;i--){
                int digit = (num / (int)Math.pow(10,i-1)) % 10;
                if(digit != 1 && digit != 0){
                    minAt = digit;
                    break;
                }
            }
        }
        int min = 0, max = 0;
        for(int i = digits; i >= 1;i--){
            int digit = (num / (int)Math.pow(10,i-1)) % 10;
            if(digit == minAt){
                min = min*10 + (minAt == firstDigit ? 1: 0);
            }else min = min * 10 + digit;
            if(digit == maxAt){
                max = max * 10 + 9;
            }else max = max * 10 + digit;
        }
        return max - min;
    }
    public static int countDigits(int n){
        int d = 0;
        while(n > 0){
            n /= 10;
            d++;
        }
        return d;
    }

    public static void main(String[] args) {
        System.out.println(maxDiff(1101057));
    }
}
