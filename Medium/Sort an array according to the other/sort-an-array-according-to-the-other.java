//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.HashMap; 
import java.util.Map; 
import java.util.Map.Entry; 


// } Driver Code Ends
//User function Template for Java

class Solution{
    // A1[] : the input array-1
    // N : size of the array A1[]
    // A2[] : the input array-2
    // M : size of the array A2[]
    
    //Function to sort an array according to the other array.
    public static int[] sortA1ByA2(int arr1[], int N, int arr2[], int M)
    {
        //Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr1){
            map.put(i , map.getOrDefault(i , 0)+1);
        }
        int[] result = new int[arr1.length];
        int idx = 0;
        for(int i : arr2){
            if(map.containsKey(i)){
                int v = map.get(i) ;
                while(v > 0){
                    result[idx++] = i;
                    v--;
                }
                map.remove(i);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            int count = map.get(key);
            while (count > 0) {
                list.add(key);
                count--;
            }
        }
        Collections.sort(list);
        for(int i = 0 ; i < list.size() ; i++){
            result[idx++] = list.get(i);
        }
        return result;
    }
}



//{ Driver Code Starts.
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    int a1[]=new int[n];
		    int a2[]=new int[m];
		    
		    for(int i=0;i<n;i++)
		    a1[i]=sc.nextInt();
		    
		    for(int i=0;i<m;i++)
		    a2[i]=sc.nextInt();
		    Solution ob=new Solution();
		    a1 = ob.sortA1ByA2(a1,n,a2,m);
		    for(int x:a1)
		    System.out.print(x+" ");
		    
		    System.out.println();
		}
	}
	

}



// } Driver Code Ends