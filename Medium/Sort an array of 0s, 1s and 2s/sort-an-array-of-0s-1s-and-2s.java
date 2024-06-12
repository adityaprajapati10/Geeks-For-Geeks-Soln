//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int nums[], int n)
    {
        // code here 
        int[] arr = new int[3];
        for(int i : nums){
            if(i == 0) arr[0]++;
            else if(i == 1) arr[1]++;
            else arr[2]++;
        }
        int indx = 0;
        while(arr[0] > 0){
            nums[indx++] = 0;
            arr[0]--;
        }
        while(arr[1] > 0){
            nums[indx++] = 1;
            arr[1]--;
        }
        while(arr[2] > 0){
            nums[indx++] = 2;
            arr[2]--;
        }
    }
}

//{ Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends