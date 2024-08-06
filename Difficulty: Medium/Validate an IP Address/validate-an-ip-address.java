//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String str) {
        // Write your code here
        String st = str.replace("."," ");
        String[] arr = st.split(" ");
        if(arr.length<4 || arr.length>4) return false;
        for(String s : arr){
            if (s.isEmpty()) return false;
            if(s.length()>1 && (s.charAt(0)) == '0') return false;
            int n = Integer.parseInt(s);
            if(n<0 || n>255) return false;
        }
        return true;
    }
}