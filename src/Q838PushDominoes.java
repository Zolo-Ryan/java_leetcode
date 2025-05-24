import java.util.Arrays;

public class Q838PushDominoes {
    public String pushDominoes(String dominoes) {
        char[] domis = dominoes.toCharArray();
        int start = 0;
        int n = domis.length;
        boolean right = false;
        /*
        * start marks the starting of subarray to be changed, j marks the ending of subarray, right to store whether 'R' is encountered or not
        * For loop
        *   if j == 'L'
        *       if right
        *           mid point collision
        *           set right to false
        *           start to j + 1
        *       else
        *           start to j convert to 'L'
        *   if j == 'R'
        *       if right encountered already
        *           fill start to j as 'R'
        *       right = true
        *       start = j
        * if right still true
        *   Fill start to n to 'R'
        * */
        for(int j = 0;j<n;j++){
            if(domis[j] == 'L'){
                if(right){
                    int mid = (j + start) / 2;
                    Arrays.fill(domis,start,mid + 1,'R');
                    Arrays.fill(domis,mid + 1,j + 1, 'L');
                    if((j-start) % 2 == 0) domis[mid] = '.';
                    right = false;
                    start = j + 1;
                }else{
                    Arrays.fill(domis,start,j+1,'L');
                }
            }else if(domis[j] == 'R'){
                if(right){
                    Arrays.fill(domis,start,j+1,'R');
                }
                right = true;
                start = j;
            }
        }
        if(right){
            Arrays.fill(domis,start,n,'R');
        }
        return new String(domis);
    }

    public String pushDominos(String dominoes){
        char[] domis = dominoes.toCharArray();
        int n = domis.length;
        int[] forces = new int[n];

        // left to right force
        int force = 0;
        for(int i = 0; i < n;i++){
            if(domis[i] == 'R') force = n;
            else if(domis[i] == 'L') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] += force;
        }
        //right to left force
        force = 0;
        for(int i = n - 1;i >= 0;i--){
            if(domis[i] == 'L') force = n;
            else if(domis[i] == 'R') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] -= force;
        }

        StringBuilder ans = new StringBuilder();
        for(int f: forces)
            ans.append(f > 0 ? 'R' : f == 0 ? '.' : 'L');
        return ans.toString();
    }
}
