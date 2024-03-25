//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<String> NBitBinary(int N) {
        // code here
        ArrayList<String> ans=new ArrayList<>();
        generate("1",N,ans);
        return ans;
    }
    
    void generate(String s,int N,ArrayList<String> ans){
        if(s.length()==N){
            if(check(s)==true){
                ans.add(s);
            }
            return;
        }
        generate(s+"1",N,ans);
        generate(s+"0",N,ans);
    }
    
    public boolean check(String s){
        int ones=0;
        int zeros=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                ones++;
            }
            if(s.charAt(i)=='0'){
                zeros++;
            }
            if(zeros>ones){
                return false;
            }
        }
        return ones>=zeros;
    }
}