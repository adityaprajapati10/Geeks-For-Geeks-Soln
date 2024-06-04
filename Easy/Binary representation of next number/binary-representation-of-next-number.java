//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.binaryNextNumber(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String binaryNextNumber(String s) {
        int n = s.length();
        char arr[] = s.toCharArray();;
        int i = 0;
        for(i = n-1 ; i>=0 ; i--){
            if(arr[i] == '1'){
                arr[i] = '0';
            }
            else{
                arr[i] = '1';
                break;
            }
        }
        StringBuilder str = new StringBuilder();
        if(i < 0){
            str.append("1");
            for(i = 0 ; i<n ; i++){
                str.append(arr[i]);
            }
        }
        else{
            i = 0;
            while(i<n && arr[i] == '0'){
                i++;
            }
            for(; i<n ; i++){
                str.append(arr[i]);
            }
        }
        return str.toString();
    }
}
