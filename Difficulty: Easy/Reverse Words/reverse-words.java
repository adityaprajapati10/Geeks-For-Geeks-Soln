//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends





class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String s)
    {
        // code here 
        StringBuilder st = new StringBuilder();
        StringBuilder word = new StringBuilder();
        int i = s.length()-1;
        while(i >= 0){

            while(i>=0 && s.charAt(i) == '.'){
                i--;
            }

            while(i>=0 && s.charAt(i) != '.'){
                word.append(s.charAt(i));
                i--;
            }
            if (word.length() > 0) {
                if (st.length() > 0) {
                    st.append('.');
                }
                st.append(word.reverse());
                word.setLength(0); 
            }
        }
        return st.toString();
        
    }
}