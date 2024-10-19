//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    String roundToNearest(String str) {
        // Complete the function
        int n = str.length();
        String result = "";
        int val = str.charAt(n-1) - '0';
        if(val <= 5){
           result = str.substring(0, n-1) + "0";
        }
        else{
            val = 10 - val;
            int carry = 0;
            for(int i = n-1; i>=0; i--){
                int temp = val + carry + (str.charAt(i)-'0');
                //System.out.println(temp);
                result = String.valueOf((temp%10)) + result;
                carry = temp/10;
                val = 0;
            }
            if(carry > 0){
                result = "1" + result;
            }
        }
        return result;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends