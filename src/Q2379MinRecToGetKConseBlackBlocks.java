public class Q2379MinRecToGetKConseBlackBlocks {
    public int minimumRecolors(String blocks, int k) {
        char[] str = blocks.toCharArray();
        int n = blocks.length();
        int w = 0;
        int minW = Integer.MAX_VALUE;
        for(int i = 0;i<k;i++)
            if(str[i] == 'W') w++;
        minW = Math.min(minW,w);
        for(int i = k+1;i<n;i++){
            if(str[i-k-1] == 'W') w--;
            if(str[i] == 'W') w++;
            minW = Math.min(minW,w);
        }
        return minW;
    }
}
