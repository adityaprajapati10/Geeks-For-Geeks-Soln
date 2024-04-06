//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int m = sc.nextInt();
                    int a[] = new int[n];
                    int b[] = new int[m];
                    for(int i = 0;i<n;i++)
                        a[i] = sc.nextInt();
                    for(int i = 0;i<m;i++)
                        b[i] = sc.nextInt();    
                    Solution ob = new Solution();
                    System.out.println(ob.maxDotProduct(n, m, a, b));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxDotProduct(int n, int m, int A[], int B[]) 
	{ 
		// Your code goes here
		int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0){
                dp[i][j]=0;
                }
                else if(i==j){
                dp[i][j]=A[i-1]*B[j-1]+dp[i-1][j-1];
                }
                else if(i>j){
                dp[i][j]=Math.max(A[i-1]*B[j-1]+dp[i-1][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
	} 
}
