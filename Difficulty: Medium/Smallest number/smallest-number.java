//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution {
    public String smallestNumber(int s, int d) {
        if(s>d*9)return "-1";
        StringBuilder res = new StringBuilder("");
        s--;
        for (int i = 0; i < d; i++) {
            if (s > 9) {
                res.append("9");
                s -= 9;
            } else {
                if(i==d-1){
                    s++;
                }
                res.append(s);
                s = 0;
            }
        }
        
    return res.reverse().toString();
    }
}
