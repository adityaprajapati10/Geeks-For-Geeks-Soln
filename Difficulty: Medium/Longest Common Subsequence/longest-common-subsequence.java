//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            String s1 = sc.next(); // Take both the strings as input
            String s2 = sc.next();

            Solution obj = new Solution();

            // Call the lcs function with the lengths of the strings as
            // parameters
            System.out.println(obj.lcs(s1, s2));
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends




class Solution {
    static int n, m;
    static int[][] dp;
    static int lcs(String s1, String s2) {
        // code here
        n = s1.length();
        m = s2.length();
        
        dp = new int[n+1][m+1];
        
        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=m; j++){
                dp[i][j] = -1;
            }
        }
        return findSubsequence(0,0, s1, s2);
    }
    static int findSubsequence(int i, int j, String s1, String s2){
        if(i >= n || j >= m){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1+findSubsequence(i+1,j+1, s1, s2);
        }
        else{
            return dp[i][j] = Math.max(findSubsequence(i+1,j, s1, s2), findSubsequence(i,j+1, s1, s2)) ;
        }
    }
}