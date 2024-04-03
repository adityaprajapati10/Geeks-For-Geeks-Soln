//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    //taking the String
		    String s=sc.nextLine();
		    Solution ob = new Solution();
		    //calling method sumSubstrings() 
		    System.out.println(ob.sumSubstrings(s));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find sum of all possible substrings of the given string.
    public static long sumSubstrings(String s)
    {
    //Your code here
    long sum = 0;
        long multiplier = 1;
        long mod = 1000000007; 
        for (int i = s.length() - 1; i >= 0; i--) {
            sum = (sum + (s.charAt(i) - '0') * multiplier * (i + 1)) % mod;
            multiplier = (multiplier * 10 + 1) % mod;
        }
        return sum;
    }
}