public class Q3306CountOfSubstringsContainingEveryVowelAndKConstants {
    public long countOfSubstrings(String word, int k) {
        char[] arr = word.toCharArray();
        for(int i = 0;i<arr.length;i++){
            
        }
        return 0l;
    }
    public int seen(char item,int val){
        if(item == 'a') return val | 1;
        else if(item == 'e') return val | 2;
        else if(item == 'i') return val | 4;
        else if(item == 'o') return val | 8;
        else if(item == 'u') return val | 16;
        else return val;
    }
}
