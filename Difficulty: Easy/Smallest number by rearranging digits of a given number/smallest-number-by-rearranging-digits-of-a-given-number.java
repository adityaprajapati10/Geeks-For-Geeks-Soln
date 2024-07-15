//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.minimum_Number(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    public String minimum_Number(String s) {
        char[] arr = s.toCharArray();
        boolean negative = false;
        
        for (char c : arr) {
            if (c == '-') {
                negative = true;
                break;
            }
        }
        
        Arrays.sort(arr);
        StringBuilder ans = new StringBuilder();
        
        if (negative) {
            ans.append("-");
            for (char c : arr) {
                if (c != '-') {
                    ans.append(c);
                }
            }
        } else {
            boolean allZeros = true;
            for (char c : arr) {
                if (c != '0') {
                    allZeros = false;
                    break;
                }
            }
            
            if (allZeros) {
                ans.append(s); 
            } else {
                int i = 0;
                while (i < arr.length && arr[i] == '0') {
                    i++;
                }
                if (i < arr.length) {
                    ans.append(arr[i]);
                    for (int j = 0; j < i; j++) {
                        ans.append('0');
                    }
                    for (int j = i + 1; j < arr.length; j++) {
                        ans.append(arr[j]);
                    }
                } else {
                    ans.append('0'); 
                }
            }
        }
        return ans.toString();
    }
}