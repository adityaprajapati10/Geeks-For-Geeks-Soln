//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
// User function Template for Java

class Solution {

    static int sameOccurrence(int arr[], int x, int y) {
        // write code here
        Map<Integer, Integer> mp = new HashMap<>();
        
        int countDiff = 0, ans = 0;

        // Initial value for the case when count difference is 0
        mp.put(0, 1);

        for (int i : arr) {
            // Increment or decrement countDiff based on occurrences of x or y
            if (i == x) {
                countDiff++;
            } else if (i == y) {
                countDiff--;
            }
            
            // If we've seen this countDiff before, it means there was a subarray where
            // x and y occurred the same number of times
            if (mp.containsKey(countDiff)) {
                ans += mp.get(countDiff);
            }
            
            // Increment the occurrence count of this countDiff
            mp.put(countDiff, mp.getOrDefault(countDiff, 0) + 1);
        }

        return ans;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
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

            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.sameOccurrence(arr, x, y);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends