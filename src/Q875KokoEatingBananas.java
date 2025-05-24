public class Q875KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for(int i = 1;i< piles.length;i++)
            max = Math.max(max,piles[i]);
        int left = 1, right = max, mid = 0;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(canEndPiles(piles,h,mid))
                right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
    public boolean canEndPiles(int[] piles,int h,int k){
        int count = 0;
        for(int i = 0;i<piles.length;i++){
            count += piles[i]/k;
            count += piles[i] % k > 0 ? 1 : 0;
            if(count > h) return false;
        }
        return true;
    }
}
