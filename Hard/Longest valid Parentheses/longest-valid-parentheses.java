//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String s){
        // code here
    int openCount = 0;
    int closeCount = 0;
    int maxLength = 0;
    
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
            openCount++;
        } else {
            closeCount++;
        }
        
        if (openCount == closeCount) {
            maxLength = Math.max(maxLength, 2 * closeCount);
        } 
        else if (closeCount > openCount) {
            openCount = closeCount = 0;
        }
        
    }
    
    openCount = closeCount = 0;
    
    for (int i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) == '(') {
            openCount++;
        } else {
            closeCount++;
        }
        
        if (openCount == closeCount) {
            maxLength = Math.max(maxLength, 2 * openCount);
        } 
        else if (closeCount < openCount) {
            openCount = closeCount = 0;
        }
    }
    
    return maxLength;
    }
}