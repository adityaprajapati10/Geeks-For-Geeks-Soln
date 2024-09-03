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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int lcs(String str1, String str2 , int i , int j , int[][]temp){
        if(i == 0 || j == 0){
            temp[i][j] = 0;
        }
        if(temp[i][j] != -1){
            return temp[i][j];
        }
        if(str1.charAt(i-1) == str2.charAt(j-1)){
            return temp[i][j] =  1+lcs(str1,str2,i-1,j-1,temp);
        }
        return temp[i][j] = Math.max(lcs(str1,str2,i,j-1,temp),lcs(str1,str2,i-1,j,temp));
    }
	public int minOperations(String str1, String str2) 
	{ 
	    int m = str1.length();
	    int n = str2.length();
	    int temp[][] = new int[m+1][n+1];
	    for(int i = 0 ; i<= m ; i++){
	        for(int j = 0 ; j<=n ; j++){
	            temp[i][j] = -1;
	        }
	    }
	    int common = lcs(str1 , str2 , m , n , temp);
	    return m+n - 2*common;
	} 
}