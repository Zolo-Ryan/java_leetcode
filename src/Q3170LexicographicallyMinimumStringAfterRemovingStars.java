import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class Q3170LexicographicallyMinimumStringAfterRemovingStars {
    private static class Node{
        Character character;
        Integer index;
        Node(Character c, Integer in){
            character = c;
            index = in;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "character=" + character +
                    ", index=" + index +
                    '}';
        }
    }
    public static String clearStars_nlogn(String s){
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node, Node t1) {
                if(node.character < t1.character){
                    return -1;
                }
                else if(node.character > t1.character){
                    return 1;
                }
                else if(node.character == t1.character){
                    return node.index - t1.index;
                }
                return 0;
            }
        });
        StringBuilder temp = new StringBuilder(s);
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) != '*') pq.offer(new Node(s.charAt(i),i));
            else{
                Node take = pq.poll();
                temp.replace(take.index,take.index + 1, "*");
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < temp.length();i++)
            if(temp.charAt(i) != '*') ans.append(temp.charAt(i));
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "aaba*";
        clearStars_nlogn(s);
    }
    // log n approach
    public static String clearStars(String s){
        Deque<Integer>[] cnt = new Deque[26];
        for(int i = 0;i<26;i++)
            cnt[i] = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        for(int i = 0;i<arr.length;i++){
            if(arr[i] != '*')
                cnt[arr[i] - 'a'].push(i);
            else{
                for(int j =0;j<26;j++)
                    if(!cnt[j].isEmpty()){
                        arr[cnt[j].pop()] = '*';
                        break;
                    }
            }
        }
        StringBuilder ans = new StringBuilder();
        for(char c: arr){
            if(c != '*') ans.append(c);
        }
        return ans.toString();
    }
}
