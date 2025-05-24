import java.util.ArrayList;
import java.util.List;

public class Q2942FindWordsContainingCharacter {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        for(int j = 0;j<words.length;j++){
            for(int i = 0;i<words[j].length();i++)
                if(words[j].charAt(i) == x){
                    list.add(j);
                    break;
                }
        }
        return list;
    }
}
