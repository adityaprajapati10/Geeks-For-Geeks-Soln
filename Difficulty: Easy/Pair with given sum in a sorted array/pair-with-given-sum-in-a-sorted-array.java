//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
         int ans=0;
        int i =0;
        int j = arr.length -1;
        
        while(i<j){
            if(arr[i]+arr[j]==target){
                ans++;
                int tempi = i+1;
                int tempj = j-1;
                
                while(tempi<j){
                    
                    if(arr[tempi]+arr[j]==target){
                        ans++;
                    }
                    tempi++;
                }
                while(tempj>i){
                    if(arr[tempj]+arr[i]==target){
                        ans++;
                    }
                    
                    tempj--;
                }
                
                j--;
                i++;
                
            }
            else if(arr[i]+arr[j]>target){
                j--;
            }else{
                i++;
            }
        }
        return ans;
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends