public class Q1550ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        boolean isOdds = false;
        int oddLen = 0;
        for(int i = 0; i < arr.length && !isOdds;i++){
            if(arr[i] % 2 == 0){
                oddLen = 0;
                continue;
            }
            oddLen++;
            if(oddLen == 3) isOdds = true;
        }
        return isOdds;
    }
}
