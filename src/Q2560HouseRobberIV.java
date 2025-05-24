public class Q2560HouseRobberIV {
    public int minCapability(int[] nums, int k) {
        return -1;
    }
    int solve(int[] arr,int i,int currentMax,int count,int k,boolean lastTaken){
        if(i >= arr.length){

        }
        int take = Integer.MAX_VALUE;
        if(!lastTaken) take = solve(arr,i+1,Math.max(currentMax,arr[i]),count+1,k,true);
        int leave = solve(arr,i+1,currentMax,count,k,false);
        if(count >= k) return Math.min(take,Math.min(leave,currentMax));
        return 0;
    }
}
