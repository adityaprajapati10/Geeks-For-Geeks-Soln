//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.longestPalinSubseq(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends






//User function Template for Java

class Solution
{
    int[][] dp;
    public int Subseq(String s , int i , int j ){
        if(i == j){
            return 1;
        }
        if(i >= j || j<0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = 2+Subseq(s,i+1,j-1);
        }
        return dp[i][j] = Math.max(Subseq(s,i+1,j),Subseq(s,i,j-1));
    }
    public int longestPalinSubseq(String S)
    {
        //code here
        int m = S.length();
        if(m == 1) return m;
        dp = new int[m+1][m+1];
        for(int i = 0 ; i<= m ; i++){
            for(int j = 0 ; j<= m ; j++){
                dp[i][j] = -1;
            }
        }
        return Subseq(S,0,m-1);
    }
}