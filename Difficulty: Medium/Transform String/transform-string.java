//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String arr[] = br.readLine().split(" ");
                    String A = arr[0];
                    String B = arr[1];
                    Solution obj = new Solution();
                    System.out.println(obj.transform (A, B));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int transform (String A, String B)
    {
        // code here
        int count = 0;
        if(!canTrans(A,B)){
            count = -1;
        }else{
            int temp = 0;
            int i = A.length() - 1;
            int j = B.length() - 1;
            while(i >= 0 && j >= 0){
                if(A.charAt(i) == B.charAt(j)){
                    temp++;
                    j--;
                }
                i--;
            }
            count = A.length() - temp;
        }
        return count;
    }
    boolean canTrans(String A , String B){
        if(A.length() != B.length()) return false;
        int[] c = new int[256];
        for(char i : A.toCharArray()){
            c[i]++;
        }
        for(char i : B.toCharArray()){
            c[i]--;
            if(c[i] < 0){
                return false;
            }
        }
        return true;
    }
}