//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Your code here
        if(n == 1 || n == 0) return 0;
        
        int[] leftMax = getLeftArr(arr , n);
        int[] rightMax = getRightArr(arr , n);
        long sum = 0;
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


