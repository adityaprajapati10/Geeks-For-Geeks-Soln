//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "-1";
        }
        
        StringBuilder ans = new StringBuilder(strs[0]);
        
        for (int i = 1; i < strs.length; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < strs[i].length() && j < ans.length(); j++) {
                if (strs[i].charAt(j) == ans.charAt(j)) {
                    temp.append(strs[i].charAt(j));
                } else {
                    break;
                }
            }
            ans = temp;
        }
        
        if (ans.length() == 0) {
            return "-1";
        }
        
        return ans.toString();
    }
}

