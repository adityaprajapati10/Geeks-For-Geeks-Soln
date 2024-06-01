//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends
class Solution {
    public static String oddEven(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int evenCount = 0; 
        int oddCount = 0; 

        for (char c : map.keySet()) {
            int frequency = map.get(c);
            int position = c - 'a' + 1; 
            
            if (position % 2 == 0 && frequency % 2 == 0) {
                evenCount++;
            } 
            else if (position % 2 != 0 && frequency % 2 != 0) {
                oddCount++;
            }
        }

        if ((evenCount + oddCount) % 2 == 0) {
            return "EVEN";
        }
        else {
            return "ODD";
        }
    }
}
