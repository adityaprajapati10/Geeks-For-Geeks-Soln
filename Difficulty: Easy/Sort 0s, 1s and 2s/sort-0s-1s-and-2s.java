//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            int a[] = new int[inputArray.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(inputArray[i]);

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}


// } Driver Code Ends
class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] nums) {
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
// } Driver Code Ends