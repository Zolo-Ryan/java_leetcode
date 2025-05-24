public class Q1358NumberOfSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = 0;
        int count = 0;
        int[] elements = new int[]{0,0,0};
        while(right < arr.length){
            elements[arr[right] - 'a']++;
            while(isValid(elements[0],elements[1],elements[2])){
                count += arr.length - right;
                elements[arr[left] - 'a']--;
                left++;
            }
            right++;
        }
        return count;
    }
    public boolean isValid(int a,int b,int c){
        return a > 0 && b > 0 && c > 0;
    }
}
