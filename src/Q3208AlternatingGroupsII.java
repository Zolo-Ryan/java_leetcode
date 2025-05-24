public class Q3208AlternatingGroupsII {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int[] extendedColors = new int[colors.length + k - 1];
        for(int i = 0;i<colors.length;i++)
            extendedColors[i] = colors[i];
        for(int i = 0;i<k-1;i++)
            extendedColors[colors.length+i] = colors[i];

        int length = extendedColors.length;
        int result = 0;
        int left = 0;
        int right = 1;
        while(right < length){
            if(extendedColors[right] == extendedColors[right-1]){
                left = right;
                right++;
                continue;
            }
            right++;
            if(right - left < k) continue;
            result++;
            left++;
        }
        return result;
    }
    public int numberOfAlternatingGroups_2(int[] colors, int k){
        int n = colors.length;
        int alternate = 1;
        int prevCol = colors[0];
        int result = 0;
        for(int i = 1;i<n;i++){
            if(prevCol == colors[i]){
                alternate = 1;
                continue;
            }
            alternate++;
            if(alternate >= k)
                result++;
            prevCol = colors[i];
        }
        for(int i = 0;i<k-1;i++){
            if(prevCol == colors[i])
                break;
            alternate++;
            if(alternate >= k)
                result++;
            prevCol = colors[i];
        }
        return result;
    }
    public int numberOfAlternatingGroups_3(int[] colors,int k){
        int n = colors.length;
        int result = 0;
        int alternate = 1;
        int prev = colors[0];
        int index = 0;
        for(int i = 1;i<n+k-1;i++){
            index = i % n;
            if(prev == colors[index]){
                alternate = 1;
                continue;
            }
            alternate++;
            if(alternate >= k) result++;
            prev = colors[index];
        }
        return result;
    }
}
