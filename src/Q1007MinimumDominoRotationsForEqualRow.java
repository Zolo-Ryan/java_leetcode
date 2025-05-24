import java.util.ArrayList;

public class Q1007MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        ArrayList<ArrayList<Integer>> positions = new ArrayList<>();
        for(int i = 0; i < 7;i++) positions.add(new ArrayList<Integer>());
        for(int i = 0; i < tops.length;i++){
            positions.get(tops[i]).add(i);
            if(tops[i] != bottoms[i]) positions.get(bottoms[i]).add(i);
        }
        int countThatOccursAtEveryIndex = -1;
        for(int i = 0; i < 7;i++){
            if(positions.get(i).size() == tops.length) {
                countThatOccursAtEveryIndex = i;
                break;
            }
        }
        if(countThatOccursAtEveryIndex == - 1) return -1;
        int occAtTop = 0, occAtBottom = 0;
        for(int i = 0; i < tops.length; i++){
            if(tops[i] == bottoms[i]) continue;
            if(tops[i] == countThatOccursAtEveryIndex) occAtTop++;
            if(bottoms[i] == countThatOccursAtEveryIndex) occAtBottom++;
        }
        return Math.min(occAtTop,occAtBottom);
    }
    public int fastMinDominoRotations(int[] tops,int[] bottoms){
        int ans = -1, curr_ans = -1;
        for(int i = 1; i < 7 ; i++){
            curr_ans = helper(tops,bottoms,i);
            if(curr_ans != -1 && (ans > curr_ans || ans == -1)) ans = curr_ans;
        }
        return ans;
    }
    public int helper(int[] tops,int[] bottoms,int val){
        int tops_swap = 0;
        int bottom_swap = 0;
        for(int i = 0; i < tops.length;i++){
            if(tops[i] != val && bottoms[i] != val) return -1;
            else if(tops[i] != val) tops_swap++;
            else if(bottoms[i] != val) bottom_swap++;
        }
        return Math.min(tops_swap,bottom_swap);
    }
}
