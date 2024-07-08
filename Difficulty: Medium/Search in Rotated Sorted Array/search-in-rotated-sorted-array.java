//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().search(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution
{
    int search(int nums[], int key)
    {
        // l: The starting index
        // h: The ending index, you have to search the key in this range
        // Complete this function
        if(nums.length == 1 && key == nums[0]){
            return 0;
        }
        int i = 0;
        for( i = 0 ; i < nums.length-1 ; i++){
            if(nums[i] > nums[i+1])
            {
                int low = 0 ; int high = i ;
                while(low<=high){
                    int mid = low+(high-low)/2;
                    if(nums[mid] == key){
                        return mid;
                    }
                    else if(nums[mid]<key){
                        low = mid+1;
                    }
                    else{
                        high = mid-1;
                    }
                }
                low = i+1 ; high = nums.length-1 ;
                while(low<=high){
                    int mid = low+(high-low)/2;
                    if(nums[mid] == key){
                        return mid;
                    }
                    else if(nums[mid]<key){
                        low = mid+1;
                    }
                    else{
                        high = mid-1;
                    }
                }
            }
        }    
            
        int low = 0 ; int high = nums.length-1 ;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == key){
                return mid;
            }
            else if(nums[mid]<key){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        } 
            
        
        return -1;
    }
}