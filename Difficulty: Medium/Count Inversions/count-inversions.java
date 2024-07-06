//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];

            for (long i = 0; i < n; i++) arr[(int)i] = sc.nextLong();

            System.out.println(new Solution().inversionCount(arr, (int)n));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long inversionCount(long nums[], int n) {
        // Your Code Here
        long gcount = mergeSort(nums , 0 , nums.length-1);
        
        return gcount;
        
    }
    public static long mergeSort(long[] arr , int l , int r){
        long count = 0;
        if(l<r){
            int mid = l+(r-l)/2;
            count += mergeSort(arr , l , mid);
            count += mergeSort(arr, mid+1 , r);
            count += mergeProcedure(arr , l , mid , r);
        }
        return count;
    }
    public static long mergeProcedure(long[] arr , int l , int mid , int h){
        long swap = 0;
        long[] lSub = Arrays.copyOfRange(arr , l , mid+1);
        long[] rSub = Arrays.copyOfRange(arr , mid+1 , h+1);

        int i = 0 , j = 0 , k = l;
        while(i<lSub.length && j<rSub.length){
            if(lSub[i] <= rSub[j]){
                arr[k++] = lSub[i++];
            }else{
                arr[k++] = rSub[j++];
                swap += (mid+1) - (l+i);
            }
        }
        while(i<lSub.length){
            arr[k++] = lSub[i++];
        }
        while(j<rSub.length){
            arr[k++] = rSub[j++];
        }
        return swap;
    }
}