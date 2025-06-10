public class Q3442MaximumDifferenceBetweenEvenAndOddFrequenceyI {
    public int maxDifference(String s) {
        int[] count = new int[26];
        char[] arr = s.toCharArray();
        for(int i = 0;i<arr.length;i++)
            count[arr[i] - 'a']++;
        int odd = Integer.MIN_VALUE;
        int even = Integer.MAX_VALUE;
        for(int i = 0; i < 26;i++){
            if(count[i] == 0) continue;
            if((count[i] & 1) == 1) odd = Math.max(odd,count[i]);
            else even = Math.min(even,count[i]);
        }
        return odd - even;
    }
}
