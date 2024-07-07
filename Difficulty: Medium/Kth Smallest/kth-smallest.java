//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        return quickSort(arr , l , r , k);
    } 
    public static int quickSort(int[] arr , int l , int h ,int k){
        if(l<=h){
            int mid = partition(arr ,  l ,  h);
            if(mid == k-1){
                return arr[mid];
            }
            else if(mid < k-1){
                return quickSort(arr , mid+1 , h , k);
            }
            else{
                return quickSort(arr , l , mid-1 , k);
            }
        }
        return -1;
    }
    public static int partition(int[] arr , int l ,int h){
        int pivot = arr[l];
        int i = l;
        for(int j = i+1 ; j<= h ; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[l];
        arr[l] = arr[i];
        arr[i] = temp;
        return i;
    }

}
