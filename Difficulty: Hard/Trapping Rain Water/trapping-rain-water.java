//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        if(n == 1 || n == 0) return 0;
        
        int[] leftMax = getLeftArr(arr , n);
        int[] rightMax = getRightArr(arr , n);
        int sum = 0;
        for(int i = 0 ; i<n ; i++){
            sum += Math.min(leftMax[i] , rightMax[i]) - arr[i] ;
        }
        return sum;
    } 
    
    public static int[] getLeftArr(int[] arr , int n){
        int[] leftMax = new int[n];
        leftMax[0] = arr[0];
        for(int i = 1 ; i<n ; i++){
            leftMax[i] = Math.max(arr[i] , leftMax[i-1]);
        }
        return leftMax;
    }
    
    public static int[] getRightArr(int[] arr , int n){
        int[] rightMax = new int[n];
        rightMax[n-1] = arr[n-1];
        for(int i = n-2 ; i>=0 ; i--){
            rightMax[i] = Math.max(arr[i] , rightMax[i+1]);
        }
        return rightMax;
    }
}
